package com.project.device.mapper;

import com.project.device.bo.Operator;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OperatorMapper {

    public void updateOperator(Operator operator);

    public void delectOperator(Integer operatorID);

    public Operator selectOperator(Integer operatorID);

    public void insertOperator(Operator operator);

}
