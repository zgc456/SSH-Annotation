package com.zheng.conf;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.orm.hibernate5.support.OpenSessionInViewFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;

import javax.servlet.*;
import javax.servlet.annotation.HandlesTypes;
import javax.servlet.http.HttpServlet;
import java.util.EnumSet;
import java.util.Set;
/**
 * 自定义servlet容器初始化，请参考servlet规范
 */
//@HandlesTypes({HttpServlet.class, Filter.class})
@HandlesTypes(WebApplicationInitializer.class)
public class WebInitializer implements ServletContainerInitializer{

    @Override
    public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
           /*
            创建struts2的核心控制器
         */
        StrutsPrepareAndExecuteFilter strutsPrepareAndExecuteFilter = ctx.createFilter(StrutsPrepareAndExecuteFilter.class);
        OpenSessionInViewFilter openSessionInViewFilter = ctx.createFilter(OpenSessionInViewFilter.class);
        /*
            向servlet容器中添加filter
         */
        ctx.addFilter("strutsPrepareAndExecuteFilter", strutsPrepareAndExecuteFilter).
                addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        FilterRegistration.Dynamic dynamic = ctx.addFilter("openSessionInViewFilter", openSessionInViewFilter);
        dynamic.setInitParameter("flushMode", "COMMIT");
        dynamic.setInitParameter("sessionFactoryBeanName","localSessionFactoryBean");
        dynamic.setInitParameter("singleSession","true");
        dynamic.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
        /*
            添加监听器
         */
        ContextLoaderListener contextLoaderListener = new ContextLoaderListener();
        ctx.addListener(contextLoaderListener);
        ctx.setInitParameter("contextClass", "com.zheng.conf.MyAnnotationConfigWebApplicationContext");

    }
}

