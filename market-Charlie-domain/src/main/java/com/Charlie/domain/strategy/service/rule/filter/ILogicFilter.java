package com.Charlie.domain.strategy.service.rule.filter;

import com.Charlie.domain.strategy.model.entity.RuleActionEntity;
import com.Charlie.domain.strategy.model.entity.RuleMatterEntity;

/**
 * @author mah
 * @description 抽奖规则过滤接口
 * @title ILogicFilter
 * @date 2025/5/28 22:01
 */
public interface ILogicFilter<T extends RuleActionEntity.RaffleEntity> {
    RuleActionEntity<T> filter(RuleMatterEntity ruleMatterEntity);
}
