package com.cw.guass2.dispatch.handler;

import java.util.concurrent.Callable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cw.guass2.common.cache.RequestCache;
import com.cw.guass2.common.constant.InvokeTypes;
import com.cw.guass2.common.constant.StatusCodes;
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
	    try {
    	    InvokeServiceManger invokeServiceManger = BeanContextUtils.getApplicationContext().getBean(InvokeServiceManger.class);
    		InvokeServiceEntity invokeServiceEntity = invokeServiceManger.getInvokeServiceEntity(requestEntity.getServiceCode());
    		requestEntity.setInvokeServiceEntity(invokeServiceEntity);
    		
    		// API调用方式
    		if(InvokeTypes.API.getCode().equals(invokeServiceEntity.getRequestType())) {
    		    APIInvokeService apiInvokeService = BeanContextUtils.getApplicationContext().getBean(APIInvokeService.class);
    			apiInvokeService.invoke(requestEntity);
    		}
    		
    		// 异步请求记录结果
    		if(requestEntity.isAsync()) {
    		        RequestCache requestCache = BeanContextUtils.getApplicationContext().getBean(RequestCache.class);
    		        requestCache.save(requestEntity);
    		}
	    }
	    catch (Exception ex) {
	        requestEntity.setStatusCode(StatusCodes.CODE_SERVER_ERROR.getCode());
	        requestEntity.setMessage(StatusCodes.CODE_SERVER_ERROR.getDesc());
	        logger.error("【服务执行失败】", ex);
        }
		
		return requestEntity;
	}
}


