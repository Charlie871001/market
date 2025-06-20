package com.Charlie.domain.strategy.service.rule.chain;

/**
 * @author mah
 * @description 责任链装配
 * @title ILogicChainArmory
 * @date 2025/6/20 15:19
 */
public interface ILogicChainArmory {
    ILogicChain next();

    ILogicChain appendNext(ILogicChain next);
}
