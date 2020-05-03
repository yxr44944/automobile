package com.yxr.car_type.service;

import com.yxr.car_type.dao.CarTypeMapper;
import com.yxr.car_type.model.CarType;
import com.yxr.car_type.model.CarTypeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述
 * @作者 yxr
 * @日期 5/2/2020 11:09 AM
 */
@Service
public class TypeService {
    @Autowired
    CarTypeMapper carTypeMapper;

    public List<CarType> typeList(){
        CarTypeExample carTypeExample = new CarTypeExample();
        carTypeExample.createCriteria().andCarPidEqualTo(0);
        return carTypeMapper.selectByExample(carTypeExample);
    }

    public List<CarType> typeListAll(Integer carPid) {
        CarTypeExample carTypeExample = new CarTypeExample();
        carTypeExample.createCriteria().andCarPidEqualTo(carPid);
        return carTypeMapper.selectByExample(carTypeExample);
    }
}
