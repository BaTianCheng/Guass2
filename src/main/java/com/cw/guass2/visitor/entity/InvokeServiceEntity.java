package com.cw.guass2.visitor.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 调用服务实体类
 * @author wicks
 *
 */
public class InvokeServiceEntity implements Serializable{

	private static final long serialVersionUID = 1077974813177199465L;
	
	/**
	 * 所属模块
	 */
	private String module;
	
	/**
	 * 服务编码
	 */
	private String serviceCode;
	
	/**
	 * 服务名称
	 */
	private String serviceName;
	
	/**
	 * 请求方式
	 */
	private String requestType;
	
	/**
	 * 映射路径
	 */
	private String mapURL;
	
	/**
	 * 异步标志
	 */
	private boolean async = true;
	
	/**
	 * 权限认证标志
	 */
	private boolean authValidate = false;
	
	/**
	 * 直接返回标志
	 */
	private boolean directReturn = false;
	
	/**
	 * 参数列表
	 */
	private List<String> params;
	
	/**
	 * 参数名称列表
	 */
	private List<String> paramNames;
	
	/**
	 * 必填参数
	 */
	private List<String> requireParams;
	
	/**
	 * 头部参数
	 */
	private List<String> headerParams;

	
	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getMapURL() {
		return mapURL;
	}

	public void setMapURL(String mapURL) {
		this.mapURL = mapURL;
	}

	public boolean isAsync() {
		return async;
	}

	public void setAsync(boolean async) {
		this.async = async;
	}

	public boolean isAuthValidate() {
		return authValidate;
	}

	public void setAuthValidate(boolean authValidate) {
		this.authValidate = authValidate;
	}

	public boolean isDirectReturn() {
		return directReturn;
	}

	public void setDirectReturn(boolean directReturn) {
		this.directReturn = directReturn;
	}

	public List<String> getParams() {
		return params;
	}

	public void setParams(List<String> params) {
		this.params = params;
	}

	public List<String> getParamNames() {
		return paramNames;
	}

	public void setParamNames(List<String> paramNames) {
		this.paramNames = paramNames;
	}

	public List<String> getRequireParams() {
		return requireParams;
	}

	public void setRequireParams(List<String> requireParams) {
		this.requireParams = requireParams;
	}

	public List<String> getHeaderParams() {
		return headerParams;
	}

	public void setHeaderParams(List<String> headerParams) {
		this.headerParams = headerParams;
	}

}
