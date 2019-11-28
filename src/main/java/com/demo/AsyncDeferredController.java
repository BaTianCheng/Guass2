package com.demo;

import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
public class AsyncDeferredController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TaskService taskService;
    
    @Autowired
    public AsyncDeferredController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @RequestMapping(value = "/callable3", method = RequestMethod.GET, produces = "text/html")
    public DeferredResult<String> executeSlowTask() {
        logger.info("Request received");
        DeferredResult<String> deferredResult = new DeferredResult<>();
        CompletableFuture.supplyAsync(taskService::execute)
            .whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));
        logger.info("Servlet thread released");
        
        return deferredResult;
    }
}
