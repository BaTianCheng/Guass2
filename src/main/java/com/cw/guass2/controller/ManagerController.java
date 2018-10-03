package com.cw.guass2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cw.guass2.controller.base.BaseController;
import com.cw.guass2.dispatch.entity.RequestEntity;


/**
 * 系统管理
 * @author wicks
 *
 */
@RestController
@RequestMapping(value = "/manager")
public class ManagerController extends BaseController{

    @RequestMapping(value = "/test")
    public String test(){
    	System.out.println(JSON.toJSONString(this.getRequestEntity()));
        return "Hello world";
    }
	
    @RequestMapping(value = "/services/{serviceCode}")
    public String getService(@PathVariable("serviceCode") String serviceCode){
    	System.out.println(serviceCode);
    	RequestEntity requestEntity = this.getRequestEntity();
    	requestEntity.setServiceCode(serviceCode);
    	System.out.println(JSON.toJSONString(requestEntity));
        return serviceCode;
    }
    
    
}
