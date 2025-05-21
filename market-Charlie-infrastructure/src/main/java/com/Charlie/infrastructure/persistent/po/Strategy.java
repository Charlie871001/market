package com.Charlie.infrastructure.persistent.po;

import lombok.Data;

import java.util.Date;

/**
 * @author Charlie
 * @description 抽奖策略
 * @title Strategy
 * @date 2025/5/21 15:07
 **/
@Data
public class Strategy {
    /** 自增ID */
    private Long id;
    /** 抽奖策略ID */
    private Long strategyId;
    /** 抽奖策略描述 */
    private String strategyDesc;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
}
