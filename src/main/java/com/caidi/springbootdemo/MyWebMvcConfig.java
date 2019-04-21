package com.caidi.springbootdemo;

import com.caidi.springbootdemo.config.MyInterceptor;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*配置springmvc*/
@SpringBootConfiguration
public class MyWebMvcConfig implements WebMvcConfigurer {

    //自定义的拦截器
    private MyInterceptor MyInterceptor;

    /*注册自定义拦截器*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(MyInterceptor).addPathPatterns("/**");
    }
}
