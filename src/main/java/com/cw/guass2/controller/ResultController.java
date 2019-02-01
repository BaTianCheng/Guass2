package com.cw.guass2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cw.guass2.common.cache.RequestCache;
import com.cw.guass2.common.constant.StatusCodes;
import com.cw.guass2.controller.base.BaseController;
import com.cw.guass2.dispatch.entity.RequestEntity;


/**
 * 响应结果
 * @author wicks
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/result")
public class ResultController extends BaseController{
    
    public static Logger logger = LoggerFactory.getLogger(ResultController.class);
	
    @Autowired
    RequestCache requestCache;
    
    @RequestMapping(value = "/get/{requestId}", produces="text/plain;charset=UTF-8")
    public String getResult(@PathVariable("requestId") String requestId){
        RequestEntity requestEntity = requestCache.get(requestId);

        if(requestEntity == null) {
            buildErrorResponse(this.buildRequestEntity(), StatusCodes.CODE_RESULT_EMPTY);
        } else {
            if(requestEntity.isDirectReturn()) {
                buildDircetResponse(requestEntity);
            }
            else {
                buildResponse(requestEntity);
            }

            logger.info("【返回结果】" + this.responseEntity.toString());
            requestCache.delete(requestId);
        }
        
        return this.responseEntity.toString();
    }
    
}
