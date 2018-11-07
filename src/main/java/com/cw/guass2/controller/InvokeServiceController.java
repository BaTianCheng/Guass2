package com.cw.guass2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cw.guass2.controller.base.BaseController;
import com.cw.guass2.dispatch.entity.RequestEntity;
import com.cw.guass2.dispatch.handler.WorkHandler;
import com.cw.guass2.dispatch.thread.service.ThreadQueue;

/**
 * 调用服务
 * @author wicks
 *
 */
@RestController
@RequestMapping(value = "/service")
public class InvokeServiceController extends BaseController{
	
    @RequestMapping(value = "/{serviceCode}")
    public String getService(@PathVariable("serviceCode") String serviceCode){
    	System.out.println(serviceCode);
    	RequestEntity requestEntity = this.getRequestEntity();
    	requestEntity.setServiceCode(serviceCode);
    	
    	WorkHandler handler = new WorkHandler(requestEntity);
    	ThreadQueue.add(handler);
    	
        return JSON.toJSONString(requestEntity);
    }

}
