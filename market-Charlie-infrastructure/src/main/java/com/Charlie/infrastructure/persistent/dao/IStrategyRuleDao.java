package com.Charlie.infrastructure.persistent.dao;

import com.Charlie.infrastructure.persistent.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mah
 * @description TODO
 * @title IStrategyRuleDao
 * @date 2025/5/21 15:14
 */
@Mapper
public interface IStrategyRuleDao {
    List<StrategyRule> queryStrategyRuleList();

    StrategyRule queryStrategyRule(StrategyRule req);
}
