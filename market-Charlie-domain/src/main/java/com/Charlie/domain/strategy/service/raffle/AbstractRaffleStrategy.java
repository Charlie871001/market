package com.Charlie.domain.strategy.service.raffle;

import com.Charlie.domain.strategy.model.entity.RaffleAwardEntity;
import com.Charlie.domain.strategy.model.entity.RaffleFactorEntity;
import com.Charlie.domain.strategy.service.IRaffleStrategy;

/**
 * @author Charlie
 * @description 抽奖策略抽象类，定义抽奖的标准流程-模板方法(Template Method)实现
 * @title AbstractRaffleStrategy
 * @date 2025/5/29 7:25
 **/
public abstract class AbstractRaffleStrategy implements IRaffleStrategy {
    @Override
    public RaffleAwardEntity performRaffle(RaffleFactorEntity raffleFactorEntity) {
        return null;
    }
}
