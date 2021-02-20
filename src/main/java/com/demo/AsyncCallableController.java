package com.demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncCallableController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final CallableTask taskService;
    
    @Autowired
    public AsyncCallableController(CallableTask taskService) {
        this.taskService = taskService;
    }

    @RequestMapping(value = "/callable", method = RequestMethod.GET, produces = "text/html")
    public  Callable<String> executeSlowTask() throws InterruptedException, ExecutionException {
        
        logger.info("Request received");
        Callable<String> callable = taskService::call;
        logger.info("Servlet thread released");   
        return callable;
    }
}
