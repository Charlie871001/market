package com.Charlie.domain.strategy.repository;

import com.Charlie.domain.strategy.model.entity.StrategyAwardEntity;
import com.Charlie.domain.strategy.model.entity.StrategyEntity;
import com.Charlie.domain.strategy.model.entity.StrategyRuleEntity;
import com.Charlie.domain.strategy.model.valobj.StrategyAwardRuleModelVO;

import java.util.List;
import java.util.Map;

/**
 * @author mah
 * @description 策略服务仓储接口
 * @title IStrategyRepository
 * @date 2025/5/23 10:15
 */
public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, int rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    int getRateRange(Long strategyId);

    int getRateRange(String key);

    Integer getStrategyAwardAssemble(String key, int rateKey);

    StrategyEntity queryStrategyByStragetyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModule);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, String ruleModel);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);
}
