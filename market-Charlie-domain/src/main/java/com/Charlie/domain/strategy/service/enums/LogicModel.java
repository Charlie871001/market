package com.Charlie.domain.strategy.service.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author mah
 * @description TODO
 * @title LogicModel
 * @date 2025/5/28 22:19
 */
@Getter
@AllArgsConstructor
public enum LogicModel {
    RULE_WIGHT("rule_weight", "【抽奖前规则】根据抽奖权重返回可抽奖范围KEY", "before"),
    RULE_BLACKLIST("rule_blacklist", "【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回", "before"),
    RULE_LOCK("rule_lock", "【抽奖中规则】抽奖n次后，对应奖品可解锁抽奖", "center"),
    RULE_LUCK_AWARD("rule_luck_award", "【抽奖后规则】抽奖n次后，对应奖品可解锁抽奖", "after"),
    ;

    private final String code;
    private final String info;
    private final String type;

    public static boolean isCenter(String code){
        return "center".equals(LogicModel.valueOf(code.toUpperCase()).type);
    }

    public static boolean isAfter(String code){
        return "after".equals(LogicModel.valueOf(code.toUpperCase()).type);
    }
}
