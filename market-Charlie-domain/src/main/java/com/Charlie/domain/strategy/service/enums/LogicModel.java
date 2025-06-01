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
    RULE_WIGHT("rule_weight", "【抽奖前规则】根据抽奖权重返回可抽奖范围KEY"),
    RULE_BLACKLIST("rule_blacklist", "【抽奖前规则】黑名单规则过滤，命中黑名单则直接返回"),
    ;

    private final String code;
    private final String info;
}
