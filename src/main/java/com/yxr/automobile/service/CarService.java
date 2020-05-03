package com.yxr.automobile.service;

import com.yxr.automobile.dao.CarMapper;
import com.yxr.automobile.model.Car;
import com.yxr.automobile.model.CarExample;
import com.yxr.automobile.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @描述
 * @作者 yxr
 * @日期 4/30/2020 10:54 PM
 */
@Service
public class CarService {
    @Autowired
    CarMapper carMapper;

    public List<CarVo> carVoList(CarVo carVo){
        return carMapper.carVoList(carVo);
    }

    public Car checkCarName(String carName) {
        CarExample carExample = new CarExample();
        carExample.createCriteria().andCarNameEqualTo(carName);
        List<Car> cars = carMapper.selectByExample(carExample);
        if (cars!=null&&cars.size()>0){
            return cars.get(0);
        }else {
            return null;
        }
    }

    public void add(Car car) {
        carMapper.insert(car);
    }

    public void delById(Integer carId) {
        carMapper.deleteByPrimaryKey(carId);
    }

    public Car queryById(Integer carId) {
        return carMapper.selectByPrimaryKey(carId);
    }

    public void update(Car car) {
        carMapper.updateByPrimaryKey(car);
    }

    public void delByIds(String[] carIds) {
        carMapper.delAll(carIds);
    }
}
