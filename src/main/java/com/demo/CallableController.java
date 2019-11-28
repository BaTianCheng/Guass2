package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallableController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final TaskService taskService;
    
    @Autowired
    public CallableController(TaskService taskService) {
        this.taskService = taskService;
    }
    
    @RequestMapping(value = "/callable2", method = RequestMethod.GET, produces = "text/html")
    public String executeSlowTask() {
        logger.info("Request received");
        String callable = taskService.execute();
        logger.info("Servlet thread released");
        
        return callable;
    }
}
