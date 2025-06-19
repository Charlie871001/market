package com.Charlie.domain.strategy.model.valobj;

import com.Charlie.domain.strategy.service.enums.LogicModel;
import com.Charlie.types.common.Constants;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Charlie
 * @description
 * @title StrategyAwardRuleModelVO
 * @date 2025/6/19 15:16
 **/
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StrategyAwardRuleModelVO {

    private String ruleModels;

    public String[] raffleCenterRuleModelList(){
        List<String> ruleModelList = Arrays.stream(ruleModels.split(Constants.SPLIT)).filter(LogicModel::isCenter).collect(Collectors.toList());
        return ruleModelList.toArray(new String[0]);
    }

    public String[] raffleAfterRuleModelList(){
        List<String> ruleModelList = Arrays.stream(ruleModels.split(Constants.SPLIT)).filter(LogicModel::isAfter).collect(Collectors.toList());
        return ruleModelList.toArray(new String[0]);
    }
}
