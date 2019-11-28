package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


/**
 * 启动类
 * @author wicks
 *
 */
@SpringBootApplication
@ComponentScan(basePackages="com")
public class App 
{
    
    public static void main(String[] args)
    {
        // 开启spring boot主程序
        SpringApplication.run(App.class);
    }
}
