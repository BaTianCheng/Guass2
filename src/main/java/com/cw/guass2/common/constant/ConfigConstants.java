package com.cw.guass2.common.constant;

/**
 * 常量配置类
 * 
 * @author wicks
 */
public class ConfigConstants {
	
	/**
	 * 最大线程数
	 */
	public static final int THREADS_MAX_NUM = 256;
	
	/**
	 * 线程监控间隔
	 */
	public static final int MONITOR_INTERVAL = 20;
	
	/**
	 * 请求超时时间
	 */
	public static final int REQUEST_TIMEOUT = 60000;
	
	/**
	 * 结果扫描间隔
	 */
	public static final int SCAN_INTERVAL = 10;
	
	/**
	 * 调用服务配置路径
	 */
	public static final String INVOKESERVICE_PATH = "conf/InvokeService.json";
	
	/**
	 * API处理类的调用函数名
	 */
	public static final String API_HANDLER_NAME = "HandlerRequest";

}
