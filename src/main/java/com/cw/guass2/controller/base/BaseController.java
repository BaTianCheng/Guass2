package com.cw.guass2.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.cw.guass2.dispatch.entity.RequestEntity;

/**
 * 控制器基类
 * @author wicks
 *
 */
public class BaseController {
	
	@Autowired
	protected HttpServletRequest request;
	
	/**
	 * 获取请求实体类
	 * @return
	 */
	protected RequestEntity getRequestEntity() {
		return new RequestEntity(request);
	}

}
