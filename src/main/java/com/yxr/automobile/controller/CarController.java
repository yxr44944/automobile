package com.yxr.automobile.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxr.automobile.feign.ClientFeignInfo;
import com.yxr.automobile.model.Car;
import com.yxr.automobile.model.CarType;
import com.yxr.automobile.service.CarService;
import com.yxr.automobile.vo.CarVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.List;

/**
 * @描述
 * @作者 yxr
 * @日期 4/30/2020 10:54 PM
 */
@Controller
@RequestMapping("/car")
public class CarController {
    //注入mapper
    @Autowired
    CarService carService;
    //注入feign
    @Autowired
    ClientFeignInfo clientFeign;
    @RequestMapping("/carList")
    public String carList(CarVo carVo, Model model, @RequestParam(defaultValue = "1")Integer cPage){
        //分页插件
        PageHelper.startPage(cPage,3);
        //sql查询到的信息
        List<CarVo> carVos = carService.carVoList(carVo);
        //进行实际价格购买计算
        for (int i = 0; i <carVos.size() ; i++) {
            //获取当前折扣
            Double rebate = carVos.get(i).getRebate();
            //算出实际价格
            carVos.get(i).setRealPrice(carVos.get(i).getPrice()*(1-rebate));
           //修改成%形式
            carVos.get(i).setRebate(rebate*100);
        }
        //分页
        PageInfo<CarVo> pageInfo = new PageInfo<CarVo>(carVos);
        //上传到网页上
        model.addAttribute("cars",pageInfo.getList());
        model.addAttribute("pageInfo",pageInfo);
        return "index";
    }

    //前往添加页面
    @RequestMapping("/toAdd")
    public String toAdd(Model model){
        List<CarType> carTypes = clientFeign.typeList();
        model.addAttribute("types",carTypes);
        return "add";
    }


    //添加或修改
    @RequestMapping("/add")
    public String add(Car car){
        //将百分比初始化
        Double rebate = car.getRebate();
        car.setRebate(rebate/100);
        //如果存在id则进行修改
        if (car.getCarId()!=null&&!"".equals(car.getCarId())){
            carService.update(car);
        }else {
            //不存在则进行添加
            carService.add(car);
        }
        //返会主页面
        return "redirect:/car/carList";
    }


    //回显类型二级联动ajax返会到页面上
    @RequestMapping("/carType")
    @ResponseBody
    public List<CarType> carType(Integer carPid){
        List<CarType> carTypes = clientFeign.typeListAll(carPid);
        return carTypes;
    }
    //检查名字是否重复
    @RequestMapping("/checkCarName")
    @ResponseBody
    public String checkCarName(String carName){
        Car car=carService.checkCarName(carName);
        return car==null?"yes":"no";
    }

    //单个删除
    @RequestMapping("/delById")
    public String delById(Integer carId){
        carService.delById(carId);
        return "redirect:/car/carList";
    }


//查找到修改的信息
    @RequestMapping("/queryById")
    public String queryById(Integer carId, Model model){
        //初始化
        Car car=carService.queryById(carId);
        Double rebate = car.getRebate();
        car.setRebate(rebate*100);
        model.addAttribute("car",car);
        List<CarType> carTypes = clientFeign.typeList();
        model.addAttribute("types",carTypes);
        return "add";
    }

    //批量删除
    @RequestMapping("/delByIds")
    public String delByIds(String carIds){
        String[] ids = carIds.split(",");
        carService.delByIds(ids);
        return "redirect:/car/carList";
    }

    
}
