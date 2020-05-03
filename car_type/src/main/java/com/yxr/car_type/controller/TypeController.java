package com.yxr.car_type.controller;

import com.yxr.car_type.model.CarType;
import com.yxr.car_type.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @描述
 * @作者 yxr
 * @日期 5/2/2020 11:08 AM
 */
@RestController
public class TypeController {
    @Autowired
    TypeService typeService;
    @RequestMapping(value = "/typeList",method = RequestMethod.POST)
    public List<CarType> typeList(){
        return typeService.typeList();
    }

    @RequestMapping(value = "/typeListAll",method = RequestMethod.POST)
    public List<CarType> typeListAll(Integer carPid){
        return typeService.typeListAll(carPid);
    }

}
