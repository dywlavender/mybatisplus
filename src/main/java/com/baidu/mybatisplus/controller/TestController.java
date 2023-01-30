package com.baidu.mybatisplus.controller;

import com.baidu.mybatisplus.threadPool.DrawThreadPoolExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class TestController {

    @Resource
    private DrawThreadPoolExecutor drawThreadPoolExecutor;

    public static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping(value = "/home/{home}",method = RequestMethod.GET)
    public String home(@PathVariable("home") String home){

        logger.info("start----");
        testAsync();
        logger.info("end-----");

        return home;
    }

    public void testAsync(){
        drawThreadPoolExecutor.getThreadPoolExecutor().execute(
            () -> {
                try {
                    logger.info(Thread.currentThread().getName()+":" + "start---");
                    Thread.sleep(10);

                    logger.info(Thread.currentThread().getName()+":" + "end---");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        );
    }
}

