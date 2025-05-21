package com.Charlie.infrastructure.persistent.dao;

import com.Charlie.infrastructure.persistent.po.Award;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author mah
 * @description 奖品表DAO
 * @title IAwardDao
 * @date 2025/5/21 15:09
 */
@Mapper
public interface IAwardDao {
    List<Award> queryAwardList();
}
