package com.example.demo.config;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    //设置druid访问页面的用户名和密码，只需要在springboot启动类中加入@bean配置即可
    @Bean
    public ServletRegistrationBean<StatViewServlet> staViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean=new ServletRegistrationBean<>(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams=new HashMap<>();

        initParams.put("loginUsername","admin");
        initParams.put("loginPassword","admin");
        initParams.put("allow","192.168.0.1");//IP白名单

        bean.setInitParameters(initParams);
        return bean;

    }
}
