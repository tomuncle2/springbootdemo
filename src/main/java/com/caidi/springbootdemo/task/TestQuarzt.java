package com.caidi.springbootdemo.task;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.util.Date;

@DisallowConcurrentExecution
public class TestQuarzt extends QuartzJobBean {

    private final Logger LOGGER = LoggerFactory.getLogger(TestQuarzt.class);
    /**
     * 执行定时任务
     * @param jobExecutionContext
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LOGGER.info("Quartz任务开始");
        System.out.println("quartz task "+new Date());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        LOGGER.info("Quartz任务结束");
    }
}
