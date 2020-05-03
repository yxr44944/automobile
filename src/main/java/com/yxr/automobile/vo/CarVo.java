package com.yxr.automobile.vo;

import com.yxr.automobile.model.Car;
import lombok.Data;

/**
 * @描述
 * @作者 yxr
 * @日期 4/30/2020 10:57 PM
 */
@Data
public class CarVo extends Car {
    private String describes;
    private Double realPrice;
}
