package com.yxr.automobile.feign;

import com.yxr.automobile.model.CarType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @描述
 * @作者 yxr
 * @日期 5/2/2020 11:32 AM
 */
@FeignClient(value = "client")
public interface ClientFeignInfo {
    @RequestMapping(value = "/typeList", method = RequestMethod.POST, consumes = "application/json")
    public List<CarType> typeList();
    @RequestMapping(value = "/typeListAll", method = RequestMethod.POST, consumes = "application/json")
    public List<CarType> typeListAll(@RequestParam("carPid") Integer carPid);

}
