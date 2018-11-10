package com.cw.guass2.dispatch.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.annotation.JSONField;
import com.cw.guass2.visitor.entity.InvokeServiceEntity;
import com.google.common.base.Strings;

/**
 * 请求实体类
 * @author wicks
 *
 */
public class RequestEntity implements Serializable{

	private static final long serialVersionUID = 2991437328372616088L;
	
	public RequestEntity(HttpServletRequest request) {
		if(request == null) {
			throw new RuntimeException("request is null");
		}
		
		requestId = UUID.randomUUID().toString();
		requestTime = System.currentTimeMillis();
		status = "100";
		requestMethod = request.getMethod();
		url =  request.getRequestURI();
		params = request.getParameterMap();
		
		//调用方地址优先选用X-Forwarded-For
		if(Strings.isNullOrEmpty(request.getHeader("X-Forwarded-For"))){
			requestIP = request.getRemoteAddr();
		} else {
			requestIP = request.getHeader("X-Forwarded-For");
		}
		
		headers = new HashMap<>();
		String tempHeaderName;
		Enumeration<String> tempHeaderNames = request.getHeaderNames();
		while(tempHeaderNames.hasMoreElements()){
			tempHeaderName = tempHeaderNames.nextElement();
			headers.put(tempHeaderName, request.getHeader(tempHeaderName));
		}
		
		if(requestMethod.equals("POST")) {
			postBody = ReadBody(request);
		}
		
		// 注入参数
		if(params.containsKey("sign")) {
			sign = params.get("sign")[0];
		}
		
		if(params.containsKey("identification")) {
			identification = params.get("identification")[0];
		}
		
		if(params.containsKey("async")) {
			async = Boolean.valueOf(params.get("async")[0]);
		}
	}
	
	/******基本属性******/
	
	/**
	 * 请求编号
	 */
	private String requestId;
	
	/**
	 * 请求时间
	 */
	private long requestTime;

	/**
	 * 执行时间
	 */
	private long excuteTime;

	/**
	 * 响应时间
	 */
	private long responseTime;
	
	/**
	 * 状态
	 */
	private String status;
	
	/**
	 * 子状态
	 */
	private String subStatus;
	
	
	/******请求属性******/
	
	/**
	 * 请求类型
	 */
	private String requestMethod;
	
	/**
	 * 请求的服务编码
	 */
	private String serviceCode;
	
	/**
	 * 请求路径
	 */
	private String url;
	
	/**
	 * 头部数据
	 */
	@JSONField(serialize=false)
	private Map<String, String> headers;

	/**
	 * 参数
	 */
	private Map<String, String[]> params;

	/**
	 * POST体数据
	 */
	private String postBody;
	
	/**
	 * 签名
	 */
	private String sign;

	/**
	 * 身份标记
	 */
	private String identification;
	
	/**
	 * 请求IP
	 */
	private String requestIP;
	
	/**
	 * 异步标志
	 */
	private boolean async = false;

	/**
	 * 是否直接返回结果
	 */
	private boolean directReturn = false;
	

	/******响应属性******/

	/**
	 * 结果字符串
	 */
	private String result;
	
	/**
	 * 消息信息
	 */
	private String message;

	/**
	 * 响应字符集
	 */
	private String responseCharset;

	/**
	 * 响应头
	 */
	private Map<String, String> responseHeaders;
	
	/******引用属性******/
	private InvokeServiceEntity invokeServiceEntity;
	
	
	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public long getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(long requestTime) {
		this.requestTime = requestTime;
	}

	public long getExcuteTime() {
		return excuteTime;
	}

	public void setExcuteTime(long excuteTime) {
		this.excuteTime = excuteTime;
	}

	public long getResponseTime() {
		return responseTime;
	}

	public void setResponseTime(long responseTime) {
		this.responseTime = responseTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubStatus() {
		return subStatus;
	}

	public void setSubStatus(String subStatus) {
		this.subStatus = subStatus;
	}

	public String getRequestMethod() {
		return requestMethod;
	}

	public void setRequestMethod(String requestMethod) {
		this.requestMethod = requestMethod;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public Map<String, String[]> getParams() {
		return params;
	}

	public void setParams(Map<String, String[]> params) {
		this.params = params;
	}

	public String getPostBody() {
		return postBody;
	}

	public void setPostBody(String postBody) {
		this.postBody = postBody;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getRequestIP() {
		return requestIP;
	}

	public void setRequestIP(String requestIP) {
		this.requestIP = requestIP;
	}

	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	public boolean isDirectReturn() {
		return directReturn;
	}

	public void setDirectReturn(boolean directReturn) {
		this.directReturn = directReturn;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getResponseCharset() {
		return responseCharset;
	}

	public void setResponseCharset(String responseCharset) {
		this.responseCharset = responseCharset;
	}

	public Map<String, String> getResponseHeaders() {
		return responseHeaders;
	}

	public void setResponseHeaders(Map<String, String> responseHeaders) {
		this.responseHeaders = responseHeaders;
	}
	
	public InvokeServiceEntity getInvokeServiceEntity() {
		return invokeServiceEntity;
	}

	public void setInvokeServiceEntity(InvokeServiceEntity invokeServiceEntity) {
		this.invokeServiceEntity = invokeServiceEntity;
	}
	
	/**
	 * 读取POSTBody
	 * @param request
	 * @return
	 */
	private static String ReadBody (HttpServletRequest request) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder("");
		try {
			br = request.getReader();
			String str;
			while ((str = br.readLine()) != null) {
				sb.append(str);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (null != br) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

}
