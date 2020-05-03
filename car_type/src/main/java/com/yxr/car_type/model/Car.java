package com.yxr.car_type.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Car {
    private Integer carId;

    private String carName;
@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date creatTime;

    private String carColor;

    private Integer typeId;

    private Integer carPid;

    private Double price;

    private Double rebate;

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName == null ? null : carName.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor == null ? null : carColor.trim();
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getCarPid() {
        return carPid;
    }

    public void setCarPid(Integer carPid) {
        this.carPid = carPid;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRebate() {
        return rebate;
    }

    public void setRebate(Double rebate) {
        this.rebate = rebate;
    }
}