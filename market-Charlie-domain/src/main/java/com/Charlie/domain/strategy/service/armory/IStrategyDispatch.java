package com.Charlie.domain.strategy.service.armory;

/**
 * @author mah
 * @description TODO
 * @title IStrategyDispache
 * @date 2025/5/25 15:38
 */
public interface IStrategyDispatch {


    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param strategyId 策略ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);
    Integer getRandomAwardId(Long strategyId,String ruleWeightValue);
}
