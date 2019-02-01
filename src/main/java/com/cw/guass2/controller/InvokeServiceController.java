package com.cw.guass2.controller;

import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cw.guass2.common.constant.StatusCodes;
import com.cw.guass2.controller.base.BaseController;
import com.cw.guass2.dispatch.entity.RequestEntity;
import com.cw.guass2.dispatch.handler.WorkHandler;
import com.cw.guass2.dispatch.thread.ThreadPoolService;
import com.cw.guass2.visitor.service.InvokeServiceManger;

/**
 * 调用服务
 * @author wicks
 *
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/service")
public class InvokeServiceController extends BaseController{
	
	public static Logger logger = LoggerFactory.getLogger(InvokeServiceController.class);
	
	@Autowired
	InvokeServiceManger invokeServiceManger;
	
    /**
     * 访问服务
     * @param serviceCode
     * @return
     */
    @RequestMapping(value = "/{serviceCode}")
    public String invokeService(@PathVariable("serviceCode") String serviceCode){
    	RequestEntity requestEntity = this.buildRequestEntity();
    	requestEntity.setServiceCode(serviceCode);
    	
    	logger.info("【接收请求】" + requestEntity.toString());
    	
    	// 创建新的工人线程，并插入队列
    	WorkHandler handler = new WorkHandler(requestEntity);
    	Future<RequestEntity> result = ThreadPoolService.submit(handler);
    	
    	// 判断同步异步方式，并返回响应
    	try {
        	if(requestEntity.isAsync()) {
                requestEntity.setStatusCode(StatusCodes.CODE_SUCCESS.getCode());
                requestEntity.setMessage(StatusCodes.CODE_SUCCESS.getDesc());
                requestEntity.setResponseTime(System.currentTimeMillis());
        	    buildDircetResponse(requestEntity);
        	} else {
        		if(requestEntity.isDirectReturn()) {
        		    buildDircetResponse(result.get());
        		}
        		else {
        		    buildResponse(result.get());
        		}
        	}
    	}
    	catch (Exception ex) {
    	    logger.error("【处理异常】", ex);
    	    buildErrorResponse(requestEntity, StatusCodes.CODE_SERVER_ERROR);
        }
    	
    	logger.info("【响应请求】" + this.responseEntity.toString());
    	
    	return this.responseEntity.toString();
    }

}
