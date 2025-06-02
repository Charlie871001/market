package com.Charlie.test.domain;

import com.Charlie.domain.strategy.model.entity.RaffleAwardEntity;
import com.Charlie.domain.strategy.model.entity.RaffleFactorEntity;
import com.Charlie.domain.strategy.service.IRaffleStrategy;
import com.Charlie.domain.strategy.service.armory.IStrategyArmory;
import com.Charlie.domain.strategy.service.rule.impl.RuleWeightLogicFilter;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;

import javax.annotation.Resource;

/**
 * @author Charlie
 * @description 抽奖策略测试
 * @title RaffleStrategyTest
 * @date 2025/6/2 14:54
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RaffleStrategyTest {

    @Resource
    private IStrategyArmory strategyArmory;
    @Resource
    private IRaffleStrategy raffleStrategy;

    @Resource
    private RuleWeightLogicFilter ruleWeightLogicFilter;

    @Before
    public void setUp() {
        ReflectionTestUtils.setField(ruleWeightLogicFilter, "userScore", 40500L);
    }

//    @Before
//    public void test_strategyArmory() {
//        boolean success = strategyArmory.assembleLotteryStrategy(100001L);
//        log.info("测试结果：{}", success);
//    }

    @Test
    public void test_performRaffle() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("Charlie")
                .strategyId(100001L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }

    @Test
    public void test_performRaffle_blacklist() {
        RaffleFactorEntity raffleFactorEntity = RaffleFactorEntity.builder()
                .userId("user003")  // 黑名单用户 user001,user002,user003
                .strategyId(100001L)
                .build();

        RaffleAwardEntity raffleAwardEntity = raffleStrategy.performRaffle(raffleFactorEntity);

        log.info("请求参数：{}", JSON.toJSONString(raffleFactorEntity));
        log.info("测试结果：{}", JSON.toJSONString(raffleAwardEntity));
    }
}
