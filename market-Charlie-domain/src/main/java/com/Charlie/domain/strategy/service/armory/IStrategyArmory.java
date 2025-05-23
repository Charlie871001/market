package com.Charlie.domain.strategy.service.armory;

/**
 * @author mah
 * @description 策略装配库(兵工厂)，负责初始化策略计算
 * @title IStrategyArmory
 * @date 2025/5/23 10:23
 */
public interface IStrategyArmory {
    /**
     * @Description 装配抽奖策略配置
     * @Date  2025/5/23
     * @Param [java.lang.Long]
     * @return boolean
     * @Author Charlie
     **/
    boolean assembleLotteryStrategy(Long strategyId);

    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param strategyId 策略ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);
}
