package com.cw.guass2.dispatch.handler;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cw.guass2.common.constant.InvokeTypes;
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
public class WorkHandler implements Callable<RequestEntity> {
	
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
     * 1）接受响应
     * 2）调用处理方式
     * 3）封装结果
     * 4）输出结果
	 */
	@Override
	public RequestEntity call() {
	    InvokeServiceManger invokeServiceManger = BeanContextUtils.getApplicationContext().getBean(InvokeServiceManger.class);
		InvokeServiceEntity invokeServiceEntity = invokeServiceManger.getInvokeServiceEntity(requestEntity.getServiceCode());
		requestEntity.setInvokeServiceEntity(invokeServiceEntity);
		
		if(InvokeTypes.API.getCode().equals(invokeServiceEntity.getRequestType())) {
		    APIInvokeService apiInvokeService = BeanContextUtils.getApplicationContext().getBean(APIInvokeService.class);
			apiInvokeService.invoke(requestEntity);
		}
		
		// 此处应记录缓存

		return requestEntity;
	}
}


