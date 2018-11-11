package com.cw.guass2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.cw.guass2.controller.base.BaseController;
import com.cw.guass2.dispatch.entity.RequestEntity;
import com.cw.guass2.dispatch.entity.ResponseEntity;
import com.cw.guass2.dispatch.handler.WorkHandler;
import com.cw.guass2.dispatch.thread.service.ThreadQueue;
import com.cw.guass2.visitor.service.InvokeServiceManger;

/**
 * 调用服务
 * @author wicks
 *
 */
@RestController
@RequestMapping(value = "/service")
public class InvokeServiceController extends BaseController{
	
	public static Logger logger = LoggerFactory.getLogger(InvokeServiceController.class);
	
	@Autowired
	InvokeServiceManger invokeServiceManger;
	
    @RequestMapping(value = "/{serviceCode}")
    public ResponseEntity getService(@PathVariable("serviceCode") String serviceCode){
    	RequestEntity requestEntity = this.getRequestEntity();
    	requestEntity.setServiceCode(serviceCode);
    	
    	logger.info("【接收请求】"+JSON.toJSONString(requestEntity));
    	
    	// 创建新的工人线程，并插入队列
    	WorkHandler handler = new WorkHandler(requestEntity);
    	ThreadQueue.add(handler);
    	
    	// 判断同步异步方式，并返回响应
    	if(requestEntity.isAsync()) {
    		getDircetResponse(requestEntity);
    	} else {
    		invokeServiceManger.syncResult(requestEntity);
    		if(requestEntity.isDirectReturn()) {
    			getDircetResponse(requestEntity);
    		}
    		else {
    			getResponse(requestEntity);
    		}
    	}
    	logger.info("【响应请求】"+JSON.toJSONString(this.responseEntity));
    	
    	return responseEntity;
    }

}
