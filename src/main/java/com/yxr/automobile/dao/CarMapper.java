package com.yxr.automobile.dao;

import com.yxr.automobile.model.Car;
import com.yxr.automobile.model.CarExample;
import java.util.List;

import com.yxr.automobile.vo.CarVo;
import org.apache.ibatis.annotations.Param;

public interface CarMapper {
    int countByExample(CarExample example);

    int deleteByExample(CarExample example);

    int deleteByPrimaryKey(Integer carId);

    int insert(Car record);

    int insertSelective(Car record);

    List<Car> selectByExample(CarExample example);

    Car selectByPrimaryKey(Integer carId);

    int updateByExampleSelective(@Param("record") Car record, @Param("example") CarExample example);

    int updateByExample(@Param("record") Car record, @Param("example") CarExample example);

    int updateByPrimaryKeySelective(Car record);

    int updateByPrimaryKey(Car record);

    List<CarVo> carVoList(CarVo car);

    int delAll(String[] carIds);
}