package com.Charlie.domain.strategy.service.annotation;

import com.Charlie.domain.strategy.service.enums.LogicModel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author mah
 * @description 策略自定义枚举
 * @title LogicStrategy
 * @date 2025/5/28 22:21
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface LogicStrategy {
    LogicModel logicModel();
}
