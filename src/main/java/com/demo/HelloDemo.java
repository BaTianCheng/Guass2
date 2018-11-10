package com.demo;

import java.util.Map;

import com.cw.guass2.common.base.ServiceHandlerInterface;
import com.cw.guass2.dispatch.entity.InvokeResultEntity;

/**
 * 服务样例————Hello world
 * @author wicks
 *
 */
public class HelloDemo implements ServiceHandlerInterface {

	@Override
	public InvokeResultEntity HandlerRequest(String questId, Map<String, String> params) {
		InvokeResultEntity responseEntity = new InvokeResultEntity();
		responseEntity.setData("hello world");
		return responseEntity;
	}

}
