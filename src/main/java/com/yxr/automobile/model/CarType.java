package com.yxr.automobile.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class CarType {
    private Integer typeId;

    private String typeName;

    private Integer carPid;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date creatTime;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Integer getCarPid() {
        return carPid;
    }

    public void setCarPid(Integer carPid) {
        this.carPid = carPid;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }
}