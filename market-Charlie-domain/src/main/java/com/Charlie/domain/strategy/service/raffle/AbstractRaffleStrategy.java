package com.Charlie.domain.strategy.service.raffle;

import com.Charlie.domain.strategy.model.entity.RaffleAwardEntity;
import com.Charlie.domain.strategy.model.entity.RaffleFactorEntity;
import com.Charlie.domain.strategy.model.entity.RuleActionEntity;
import com.Charlie.domain.strategy.model.entity.StrategyEntity;
import com.Charlie.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.Charlie.domain.strategy.repository.IStrategyRepository;
import com.Charlie.domain.strategy.service.IRaffleStrategy;
import com.Charlie.domain.strategy.service.armory.IStrategyDispatch;
import com.Charlie.domain.strategy.service.enums.LogicModel;
import com.Charlie.types.enums.ResponseCode;
import com.Charlie.types.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author Charlie
 * @description 抽奖策略抽象类，定义抽奖的标准流程-模板方法(Template Method)实现
 * @title AbstractRaffleStrategy
 * @date 2025/5/29 7:25
 **/
@Slf4j
@Service
public abstract class AbstractRaffleStrategy implements IRaffleStrategy {

    private IStrategyRepository repository;

    private IStrategyDispatch strategyDispatch;

    public AbstractRaffleStrategy(IStrategyRepository repository, IStrategyDispatch strategyDispatch) {
        this.repository = repository;
        this.strategyDispatch = strategyDispatch;
    }

    @Override
    public RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity) {
        // 1. 参数校验
        Long strategyId = raffleFactorEntity.getStrategyId();
        String userId = raffleFactorEntity.getUserId();
        if (null == strategyId || StringUtils.isBlank(userId)) {
            throw new AppException(ResponseCode.ILLEGAL_PARAMETER.getCode(), ResponseCode.ILLEGAL_PARAMETER.getInfo());
        }
        // 2. 策略查询
        StrategyEntity strategyEntity = repository.queryStrategyByStragetyId(strategyId);
        // 3. 抽奖前 - 规则过滤
        RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> ruleActionEntity = this.doCheckRaffleBeforeLogic(RaffleFactorEntity.builder().userId(userId).strategyId(strategyId).build(), strategyEntity.ruleModels());
        if (RuleLogicCheckTypeVO.TAKE_OVER.getCode().equals(ruleActionEntity.getCode())) {
            // 黑名单返回固定的奖品ID
            if (LogicModel.RULE_BLACKLIST.getCode().equals(ruleActionEntity.getRuleModel())) {
                return RaffleAwardEntity.builder().awardId(ruleActionEntity.getData().getAwardId()).build();
            } else if (LogicModel.RULE_WIGHT.getCode().equals(ruleActionEntity.getRuleModel())) {
                // 根据权重抽奖
                String ruleWeightValueKey = ruleActionEntity.getData().getRuleWeightValueKey();
                Integer awardId = strategyDispatch.getRandomAwardId(strategyId, ruleWeightValueKey);
                return RaffleAwardEntity.builder().awardId(awardId).build();
            }

        }
        // 4. 默认抽奖流程
        Integer awardId = strategyDispatch.getRandomAwardId(strategyId);
        return RaffleAwardEntity.builder().awardId(awardId).build();
    }

    protected abstract RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> doCheckRaffleBeforeLogic(RaffleFactorEntity raffleFactorEntity, String... logics);

}
