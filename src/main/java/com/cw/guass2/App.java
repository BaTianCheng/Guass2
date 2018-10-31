package com.cw.guass2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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
    public static void main(String[] args)
    {
    	
        SpringApplication.run(App.class, args);
        
        MonitorRunnable monitorRunnable = new MonitorRunnable();
        monitorRunnable.run();
        
        //InvokeServiceManger invokeServiceManger = new InvokeServiceManger();
    	//invokeServiceManger.loadInvokeServiceEntities();
    }
}
