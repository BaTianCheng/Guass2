package com.cw.guass2.visitor.service.invoke;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.cw.guass2.common.constant.ConfigConstants;
import com.cw.guass2.common.constant.StatusCodes;
import com.cw.guass2.dispatch.entity.RequestEntity;
import com.cw.guass2.dispatch.entity.InvokeResultEntity;
import com.cw.guass2.dispatch.entity.ParamEntity;


/**
 * API调用方式
 * @author wicks
 *
 */
@Service
public class APIInvokeService {
	
	public static Logger logger = LoggerFactory.getLogger(APIInvokeService.class);
	
	/**
	 * 调用
	 * @param requestEntity
	 * @return
	 */
	public void invoke(RequestEntity requestEntity){
	    
	    // TO-DO 各种结果封装
		
		InvokeResultEntity result = new InvokeResultEntity();
		
		try {
			if(null != requestEntity.getInvokeServiceEntity() && null != requestEntity.getInvokeServiceEntity().getMapURL()) {
				Class<?> clazz = Class.forName(requestEntity.getInvokeServiceEntity().getMapURL());
				Method method = clazz.getMethod(ConfigConstants.API_HANDLER_NAME, String.class, ParamEntity.class);
				result = (InvokeResultEntity) method.invoke(clazz.newInstance(), requestEntity.getRequestId(), new ParamEntity(requestEntity.getParams()));
				requestEntity.setResponseTime(System.currentTimeMillis());
				
				// 回收资源
				clazz = null;
				method = null;
			}
			
			// 执行处理程序成功
			if(result.isSuccessFlag()) {
			    requestEntity.setStatusCode(StatusCodes.CODE_SUCCESS.getCode());
			    requestEntity.setMessage(StatusCodes.CODE_SUCCESS.getDesc());
	            requestEntity.setResult(result.getData());
			} else {
				requestEntity.setStatusCode(StatusCodes.CODE_SERVER_ERROR.getCode());
				requestEntity.setMessage(StatusCodes.CODE_SERVER_ERROR.getDesc());
				requestEntity.setSubStatus(result.getStatus());
				requestEntity.setSubMessage(result.getMessage());
				requestEntity.setResult(result.getData());
			}
			
			
		} catch(Throwable thrown) {
			requestEntity.setResponseTime(System.currentTimeMillis());
			requestEntity.setStatusCode(StatusCodes.CODE_SERVER_ERROR.getCode());
			logger.error("API请求发送异常：" + requestEntity.getRequestId(), thrown);
		}
	}

}
