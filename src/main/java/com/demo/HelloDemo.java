package com.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;

import com.alibaba.fastjson.JSON;
import com.cw.guass2.common.base.BaseServiceHandler;
import com.cw.guass2.common.util.BeanContextUtils;
import com.cw.guass2.dispatch.entity.InvokeResultEntity;
import com.cw.guass2.dispatch.entity.ParamEntity;

/**
 * 服务样例————Hello world
 * @author wicks
 *
 */
public class HelloDemo extends BaseServiceHandler{
    
//    @Autowired
//    HelloService helloService;
//    private ApplicationContext applicationContext;

	@Override
	public InvokeResultEntity HandlerRequest(String questId, ParamEntity params) {
	    //helloService = BeanContextUtils.getApplicationContext().getBean(HelloService.class);
	    HelloService helloService = BeanContextUtils.getBean(HelloService.class);
		return buidSucessResult(helloService.getHello() + ";"+ JSON.toJSONString(params.getParamMap()));
	}


}
