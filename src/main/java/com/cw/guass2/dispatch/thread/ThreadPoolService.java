package com.cw.guass2.dispatch.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import com.cw.guass2.common.constant.ConfigConstants;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * 线程池服务类
 * 
 * @author wicks
 */
@Component
public class ThreadPoolService {

	private static ExecutorService threadPool;

	static {
	    ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-pool-%d").build();
	    threadPool = new ThreadPoolExecutor(ConfigConstants.THREADS_CORE_NUM, ConfigConstants.THREADS_MAX_NUM, 0L, 
		    TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>(ConfigConstants.THREADS_MAX_QUENUE), 
		    namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
	}

	/**
	 * 执行线程
	 * @param runnable
	 */
	public static void execute(Runnable runnable) {
		if(runnable != null) {
		    threadPool.execute(runnable);
		}
	}
	
	/**
	 * 提交线程
	 * @param <T>
	 * @param callable
	 * @return
	 */
	public static <T> Future<T> submit(Callable<T> callable) {
         return threadPool.submit(callable);
	}

	/**
	 * 获取正在执行数
	 * @return
	 */
	public static int getActiveCount() {
		return ((ThreadPoolExecutor)threadPool).getActiveCount();
	}

}

