package com.Charlie.domain.strategy.service.rule.impl;

import com.Charlie.domain.strategy.model.entity.RuleActionEntity;
import com.Charlie.domain.strategy.model.entity.RuleMatterEntity;
import com.Charlie.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.Charlie.domain.strategy.repository.IStrategyRepository;
import com.Charlie.domain.strategy.service.annotation.LogicStrategy;
import com.Charlie.domain.strategy.service.enums.LogicModel;
import com.Charlie.domain.strategy.service.rule.ILogicFilter;
import com.Charlie.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Charlie
 * @description 【抽奖前规则】黑名单用户过滤规则
 * @title RuleBackListLogicFilter
 * @date 2025/5/30 16:32
 **/
@Slf4j
@Component
@LogicStrategy(logicModel = LogicModel.RULE_BLACKLIST)
public class RuleBackListLogicFilter implements ILogicFilter<RuleActionEntity.RaffleBeforeEntity> {

    @Resource
    private IStrategyRepository repository;

    @Override
    public RuleActionEntity<RuleActionEntity.RaffleBeforeEntity> filter(RuleMatterEntity ruleMatterEntity) {
        log.info("规则过滤-黑名单 userId:{} strategyId:{} ruleModel:{}", ruleMatterEntity.getUserId(), ruleMatterEntity.getStrategyId(), ruleMatterEntity.getRuleModel());

        String userId = ruleMatterEntity.getUserId();
        // 查询规则配置
        String ruleValue = repository.queryStrategyRuleValue(ruleMatterEntity.getStrategyId(), ruleMatterEntity.getAwardId(), ruleMatterEntity.getRuleModel());
        String[] ruleValueSplit = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(ruleValueSplit[0]);

        // 过滤黑名单
        String[] userBlackIds = ruleValueSplit[1].split(Constants.SPLIT);
        for (String userBlackId : userBlackIds) {
            if (userId.equals(userBlackId)) {
                return RuleActionEntity.<RuleActionEntity.RaffleBeforeEntity>builder()
                        .code(RuleLogicCheckTypeVO.TAKE_OVER.getCode())
                        .info(RuleLogicCheckTypeVO.TAKE_OVER.getInfo())
                        .ruleModel(LogicModel.RULE_BLACKLIST.getCode())
                        .data(RuleActionEntity.RaffleBeforeEntity.builder()
                                .awardId(awardId).build())
                        .build();
            }
        }
        return RuleActionEntity.<RuleActionEntity.RaffleBeforeEntity>builder()
                .code(RuleLogicCheckTypeVO.ALLOW.getCode())
                .info(RuleLogicCheckTypeVO.ALLOW.getInfo())
                .build();
    }
}
