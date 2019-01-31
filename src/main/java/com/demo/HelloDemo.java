package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cw.guass2.common.base.BaseServiceHandler;
import com.cw.guass2.dispatch.entity.InvokeResultEntity;
import com.cw.guass2.dispatch.entity.ParamEntity;

/**
 * 服务样例————Hello world
 * @author wicks
 *
 */
@Component(value = "com.demo.HelloDemo")
public class HelloDemo extends BaseServiceHandler{

    @Autowired
    HelloService helloService;
    
	@Override
	public InvokeResultEntity HandlerRequest(String questId, ParamEntity params) {
		return buidSucessResult(helloService.say());
	}


}
