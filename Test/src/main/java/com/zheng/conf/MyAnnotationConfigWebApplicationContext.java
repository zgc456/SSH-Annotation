package com.zheng.conf;

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

/**
 * 这个类用于初始化Spring ，为了在ContextLoaderListener初始化注解配置时使用
 */
public class MyAnnotationConfigWebApplicationContext extends AnnotationConfigWebApplicationContext {
    public MyAnnotationConfigWebApplicationContext(){
        this.register(Spring.class);
    }
}
