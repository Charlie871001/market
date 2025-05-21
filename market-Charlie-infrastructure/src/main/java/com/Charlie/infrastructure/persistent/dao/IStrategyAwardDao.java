package com.Charlie.infrastructure.persistent.dao;

import com.Charlie.infrastructure.persistent.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mah
 * @description TODO
 * @title IStrategyAwardDao
 * @date 2025/5/21 15:14
 */
@Mapper
public interface IStrategyAwardDao {
    List<StrategyAward> queryStrategyAwardList();

}
