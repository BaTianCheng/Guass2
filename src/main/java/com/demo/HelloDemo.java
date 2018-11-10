package com.demo;

import java.util.Map;

import com.cw.guass2.common.base.ServiceHandlerInterface;
import com.cw.guass2.dispatch.entity.ResponseEntity;

/**
 * 服务样例————Hello world
 * @author wicks
 *
 */
public class HelloDemo implements ServiceHandlerInterface {

	@Override
	public ResponseEntity HandlerRequest(String questId, Map<String, String> params) {
		ResponseEntity responseEntity = new ResponseEntity();
		responseEntity.setData("hello world");
		return responseEntity;
	}

}
