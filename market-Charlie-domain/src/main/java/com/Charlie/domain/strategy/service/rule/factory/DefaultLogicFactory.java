package com.Charlie.domain.strategy.service.rule.factory;

import com.Charlie.domain.strategy.model.entity.RuleActionEntity;
import com.Charlie.domain.strategy.service.annotation.LogicStrategy;
import com.Charlie.domain.strategy.service.enums.LogicModel;
import com.Charlie.domain.strategy.service.rule.ILogicFilter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Charlie
 * @description 规则工厂
 * @title DefaultLogicFactory
 * @date 2025/6/2 10:00
 **/
@Service
public class DefaultLogicFactory {
    private Map<String, ILogicFilter<?>> logicFilterMap = new HashMap<>();

    public DefaultLogicFactory(List<ILogicFilter<?>> logicFilters) {
        logicFilters.forEach(logic -> {
            LogicStrategy strategy = AnnotationUtils.findAnnotation(logic.getClass(), LogicStrategy.class);
            if (null != strategy) {
                logicFilterMap.put(strategy.logicModel().getCode(),logic);
            }
        });
    }

    public <T extends RuleActionEntity.RaffleEntity> Map<String,ILogicFilter<T>> openLogicFilter(){
        return (Map<String,ILogicFilter<T>>) (Map)logicFilterMap;
    }

}
