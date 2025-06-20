package com.Charlie.domain.strategy.service.rule.chain.impl;

import com.Charlie.domain.strategy.model.entity.RuleActionEntity;
import com.Charlie.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import com.Charlie.domain.strategy.repository.IStrategyRepository;
import com.Charlie.domain.strategy.service.enums.LogicModel;
import com.Charlie.domain.strategy.service.rule.chain.AbstractLogicChain;
import com.Charlie.types.common.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Charlie
 * @description
 * @title BackListLogicChain
 * @date 2025/6/20 16:08
 **/
@Slf4j
@Component("rule_blacklist")
public class BackListLogicChain extends AbstractLogicChain {

    @Resource
    private IStrategyRepository repository;

    @Override
    public Integer logic(String userId, Long strategyId) {
        // 查询规则配置
        String ruleValue = repository.queryStrategyRuleValue(strategyId, ruleModel());
        String[] ruleValueSplit = ruleValue.split(Constants.COLON);
        Integer awardId = Integer.parseInt(ruleValueSplit[0]);

        // 过滤黑名单
        String[] userBlackIds = ruleValueSplit[1].split(Constants.SPLIT);
        for (String userBlackId : userBlackIds) {
            if (userId.equals(userBlackId)) {
                log.info("抽奖责任链-黑名单接管 userId: {} strategyId: {} ruleModel: {} awardId: {}", userId, strategyId, ruleModel(), awardId);
                return awardId;
            }
        }
        // 过滤其他责任链
        log.info("抽奖责任链-黑名单放行 userId: {} strategyId: {} ruleModel: {}", userId, strategyId, ruleModel());
        return next().logic(userId, strategyId);
    }

    @Override
    protected String ruleModel() {
        return "rule_blacklist";
    }
}
