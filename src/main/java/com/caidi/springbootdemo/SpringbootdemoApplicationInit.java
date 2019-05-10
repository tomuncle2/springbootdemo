package com.caidi.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/*
打war包需要继承springboot初始化类，springboot自动生成，运行类
以替代spring传统项目的web.xml(tomcat等容器读取)
 */
@EnableScheduling
@EnableCaching
@SpringBootApplication(exclude = {QuartzAutoConfiguration.class})
//扫描包下面的持久化类
//@MapperScan(basePackages={"com.caidi.springbootdemo.MybatisDao.*"})
public class SpringbootdemoApplicationInit extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        //return super.configure(builder);
        return builder.sources(SpringbootdemoApplicationInit.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringbootdemoApplicationInit.class,args);
    }
}
