package com.caidi.springbootdemo;

import com.caidi.springbootdemo.config.QuartzConfig;
import com.caidi.springbootdemo.config.RedisConfig;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.quartz.QuartzAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(exclude = {QuartzAutoConfiguration.class})
@EnableScheduling
@EnableCaching
//@ConditionalOnClass
public class SpringbootdemoApplication implements CommandLineRunner{

//    public static void main(String[] args) {
//        SpringApplication app = new SpringApplication(SpringbootdemoApplication.class);
//        app.setBannerMode(Banner.Mode.CONSOLE);
//        app.run(args);
//        //SpringApplication.run(SpringbootdemoApplication.class, args);
//    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("springboot启动初始化数据=========");
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringbootdemoApplication.class);
        app.run(args);
    }
}
