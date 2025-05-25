package com.Charlie.infrastructure.persistent.dao;

import com.Charlie.infrastructure.persistent.po.Strategy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mah
 * @description TODO
 * @title IStrategyDao
 * @date 2025/5/21 15:13
 */
@Mapper
public interface IStrategyDao {
    List<Strategy> queryStrategyList();

    Strategy queryStrategyByStrategyId(Long strategyId);
}
