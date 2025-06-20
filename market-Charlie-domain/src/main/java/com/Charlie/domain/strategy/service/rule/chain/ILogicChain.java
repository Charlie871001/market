package com.Charlie.domain.strategy.service.rule.chain;

/**
 * @author mah
 * @description 抽奖策略规则责任链接口
 * @title ILogicChain
 * @date 2025/6/20 14:42
 */
public interface ILogicChain extends ILogicChainArmory{

    /**
     * 责任链接口
     *
     * @param userId     用户ID
     * @param strategyId 策略ID
     * @return 奖品ID
     */
    Integer logic(String userId, Long strategyId);
}
