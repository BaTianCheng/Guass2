package com.demo;

import java.util.Map;

import com.cw.guass2.common.base.BaseServiceHandler;
import com.cw.guass2.dispatch.entity.InvokeResultEntity;

/**
 * 服务样例————Hello world
 * @author wicks
 *
 */
public class HelloDemo extends BaseServiceHandler {

	@Override
	public InvokeResultEntity HandlerRequest(String questId, Map<String, String> params) {
		String str = "hello world";
		return buidSucessResult(str);
	}

}
