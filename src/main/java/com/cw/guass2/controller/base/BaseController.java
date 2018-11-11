package com.cw.guass2.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

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
	protected RequestEntity getRequestEntity() {
		return new RequestEntity(request);
	}
	
	/**
	 * 返回响应结果（同步）
	 * @param requestEntity
	 * @return
	 */
	protected void getResponse(RequestEntity requestEntity) {
		responseEntity = new ResponseEntity(requestEntity);
	}
	
	/**
	 * 返回响应结果（异步）
	 * @param requestEntity
	 * @return
	 */
	protected void getResultResponse(RequestEntity requestEntity) {
		responseEntity = new ResponseEntity(requestEntity);
	}
	
	/**
	 * 返回响应结果（直接）
	 * @param requestEntity
	 * @return
	 */
	protected void getDircetResponse(RequestEntity requestEntity) {
		responseEntity = new ResponseEntity(requestEntity);
	}

}
