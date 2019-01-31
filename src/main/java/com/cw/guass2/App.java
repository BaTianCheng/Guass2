package com.cw.guass2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.cw.guass2.common.util.BeanContextUtils;
import com.cw.guass2.visitor.service.InvokeServiceManger;


/**
 * 启动类
 * @author wicks
 *
 */
@SpringBootApplication
@ComponentScan(basePackages="com")
public class App 
{
    public static void deploy() 
    {
        // 默认首次加载所有服务定义
        InvokeServiceManger invokeServiceManger = BeanContextUtils.getApplicationContext().getBean(InvokeServiceManger.class);
        invokeServiceManger.loadInvokeServiceEntities();
    }
    
    public static void main(String[] args)
    {
        // 开启spring boot主程序
        SpringApplication.run(App.class);
        deploy();
    }
}
