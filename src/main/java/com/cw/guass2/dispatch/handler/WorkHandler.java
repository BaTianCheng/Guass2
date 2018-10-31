package com.cw.guass2.dispatch.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.cw.guass2.common.util.BeanContextUtils;
import com.cw.guass2.dispatch.entity.RequestEntity;
import com.cw.guass2.visitor.entity.InvokeServiceEntity;
import com.cw.guass2.visitor.service.InvokeServiceManger;
import com.cw.guass2.visitor.service.invoke.APIInvokeService;

/**
 * 工作处理类————处理所有线程工作
 * @author wicks
 *
 */
public class WorkHandler implements Runnable {
	
	InvokeServiceManger invokeServiceManger = BeanContextUtils.getApplicationContext().getBean(InvokeServiceManger.class);

	APIInvokeService apiInvokeService = BeanContextUtils.getApplicationContext().getBean(APIInvokeService.class);

	public static Logger logger = LoggerFactory.getLogger(WorkHandler.class);
	
	private RequestEntity requestEntity;

	/**
	 * 构造函数
	 */
	public WorkHandler(RequestEntity requestEntity) {
		super();
		this.requestEntity = requestEntity;
	}
	
	/**
	 * 执行线程工作
	 */
	@Override
	public void run() {
		/*
		 * 工作流程：
		 * 1）接受响应
		 * 2）调用处理方式
		 * 3）封装结果
		 * 4）输出结果
		 */
		invokeServiceManger.loadInvokeServiceEntities();
		InvokeServiceEntity invokeServiceEntity = invokeServiceManger.getInvokeServiceEntity(requestEntity.getServiceCode());
		requestEntity.setInvokeServiceEntity(invokeServiceEntity);
		
		if(invokeServiceEntity.getRequestType().equals("API")) {
			apiInvokeService.invoke(requestEntity);
		}

		System.out.println(JSON.toJSON(requestEntity));
	}
}


