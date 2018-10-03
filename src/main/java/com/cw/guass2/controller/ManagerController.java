package com.cw.guass2.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cw.guass2.controller.base.BaseController;


/**
 * 系统管理
 * @author wicks
 *
 */
@RestController
@RequestMapping(value = "/manager")
public class ManagerController extends BaseController{

    @RequestMapping(value = "test")
    public String test(){
    	System.out.println(JSON.toJSONString(this.getRequestEntity()));
        return "Hello world";
    }
	
}
