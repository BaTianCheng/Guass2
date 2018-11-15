package com.cw.guass2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cw.guass2.common.util.BeanContextUtils;
import com.cw.guass2.dispatch.thread.runnable.MonitorRunnable;
import com.cw.guass2.visitor.service.InvokeServiceManger;


/**
 * 启动类
 * @author wicks
 *
 */
@SpringBootApplication
public class App 
{
    public static void start() 
    {
        // 开启spring boot主程序
        SpringApplication.run(App.class);
        
        // 默认首次加载所有服务定义
        InvokeServiceManger invokeServiceManger = BeanContextUtils.getApplicationContext().getBean(InvokeServiceManger.class);
        invokeServiceManger.loadInvokeServiceEntities();
        
        // 开启监控线程，处理线程池任务
        MonitorRunnable monitorRunnable = new MonitorRunnable();
        monitorRunnable.run();
    }
    
    public static void main(String[] args)
    {
        start();
    }
}
