package com.cw.guass2.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.cw.guass2.common.constant.StatusCodes;
import com.cw.guass2.dispatch.entity.RequestEntity;
import com.cw.guass2.dispatch.entity.ResponseEntity;

/**
 * 控制器基类
 * @author wicks
 *
 */
public class BaseController {
	
	@Autowired
	protected HttpServletRequest request;
	
	protected ResponseEntity responseEntity;
	
	/**
	 * 获取请求实体类
	 * @return
	 */
	protected RequestEntity buildRequestEntity() {
		return new RequestEntity(request);
	}
	
	/**
	 * 返回响应结果（同步）
	 * @param requestEntity
	 * @return
	 */
	protected void buildResponse(RequestEntity requestEntity) {
		responseEntity = new ResponseEntity(requestEntity);
	}
	
	/**
	 * 返回响应结果（异步）
	 * @param requestEntity
	 * @return
	 */
	protected void buildResultResponse(RequestEntity requestEntity) {
		responseEntity = new ResponseEntity(requestEntity);
	}
	
	/**
	 * 返回响应结果（直接）
	 * @param requestEntity
	 * @return
	 */
	protected void buildDircetResponse(RequestEntity requestEntity) {
		responseEntity = new ResponseEntity(requestEntity);
	}
	
	/**
     * 返回错误响应结果
     * @param requestEntity
     * @return
     */
    protected void buildErrorResponse(RequestEntity requestEntity, StatusCodes statusCode) {
        requestEntity.setStatusCode(statusCode.getCode());
        requestEntity.setMessage(statusCode.getDesc());
        requestEntity.setResponseTime(System.currentTimeMillis());
        responseEntity = new ResponseEntity(requestEntity);
    }

}
