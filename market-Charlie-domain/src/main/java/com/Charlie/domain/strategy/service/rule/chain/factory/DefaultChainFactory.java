package com.Charlie.domain.strategy.service.rule.chain.factory;

import com.Charlie.domain.strategy.model.entity.StrategyEntity;
import com.Charlie.domain.strategy.repository.IStrategyRepository;
import com.Charlie.domain.strategy.service.rule.chain.ILogicChain;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author Charlie
 * @description 责任链工厂
 * @title DefaultChainFactory
 * @date 2025/6/20 17:04
 **/
@Service
public class DefaultChainFactory {

    private final Map<String, ILogicChain> logicChainGroup;

    protected IStrategyRepository repository;

    public DefaultChainFactory(Map<String, ILogicChain> logicChainGroup, IStrategyRepository repository) {
        this.logicChainGroup = logicChainGroup;
        this.repository = repository;
    }

    /**
     * 通过策略ID，构建责任链
     *
     * @param strategyId 策略ID
     * @return LogicChain
     */
    public ILogicChain openLogicChain(Long strategyId) {
        StrategyEntity strategy = repository.queryStrategyByStragetyId(strategyId);
        String[] ruleModels = strategy.ruleModels();

        // 如果未配置策略规则，则只装填一个默认责任链
        if (null == ruleModels || 0 == ruleModels.length) {
            return logicChainGroup.get("default");
        }
        ILogicChain logicChain = logicChainGroup.get(ruleModels[0]);
        ILogicChain current = logicChain;
        for (int i = 1; i < ruleModels.length; i++) {
            ILogicChain nextChain = logicChainGroup.get(ruleModels[i]);
            current = current.appendNext(nextChain);
        }


        return logicChain;
    }
}
