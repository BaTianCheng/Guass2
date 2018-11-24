package com.cw.guass2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cw.guass2.controller.base.BaseController;
import com.cw.guass2.visitor.service.InvokeServiceManger;


/**
 * 系统管理
 * @author wicks
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/manager")
public class ManagerController extends BaseController{
	
	@Autowired
	InvokeServiceManger invokeServiceManger;
    
    @RequestMapping(value = "/services/list", produces="text/plain;charset=UTF-8")
    public String listServices(){
        return JSON.toJSONString(invokeServiceManger.listInvokeServiceEntities());
    }
    
}
