package com.cw.guass2.controller.base;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import com.cw.guass2.dispatch.entity.RequestEntity;

public class BaseController {
	
	@Autowired
	protected HttpServletRequest request;
	
	protected RequestEntity getRequestEntity() {
		return new RequestEntity(request);
	}

}
