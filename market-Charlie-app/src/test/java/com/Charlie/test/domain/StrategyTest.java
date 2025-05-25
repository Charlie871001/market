package com.Charlie.test.domain;

import com.Charlie.domain.strategy.service.armory.IStrategyArmory;
import com.Charlie.infrastructure.redis.IRedisService;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RMap;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author Charlie
 * @description 策略领域测试
 * @title StrategyTest
 * @date 2025/5/22 9:43
 **/
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {

    @Resource
    private IRedisService redisService;

    @Resource
    private IStrategyArmory strategyArmory;

    @Test
    public void test_map(){
        RMap<Integer, Integer> map = redisService.getMap("strategy_id_100001");
        map.put(1, 101);
        map.put(2, 101);
        map.put(3, 101);
        map.put(4, 102);
        map.put(5, 102);
        map.put(6, 102);
        map.put(7, 103);
        map.put(8, 103);
        map.put(9, 104);
        map.put(10, 105);

        log.info("测试结果：{}", redisService.getMap("strategy_id_100001").get(1));
    }

    /**
     * 策略ID；100001L、100002L 装配的时候创建策略表写入到 Redis Map 中
     */
    @Test
    public void test_strategyArmory() {
        boolean success = strategyArmory.assembleLotteryStrategy(100002L);
        log.info("测试结果：{}", success);
    }

    /**
     * 从装配的策略中随机获取奖品ID值
     */
    @Test
    public void test_getAssembleRandomVal() {
//        log.info("测试结果：{} - 奖品ID值", strategyArmory.getRandomAwardId(100002L));
    }

}
