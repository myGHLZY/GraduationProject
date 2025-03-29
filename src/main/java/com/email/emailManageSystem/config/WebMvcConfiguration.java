package com.email.emailManageSystem.config;

import com.email.emailManageSystem.Interceptor.Admin.AdminLoginInterceptor;
import com.email.emailManageSystem.Interceptor.Admin.AdminPermissionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author userlzy
 * @version 1.0
 * @description: WebMvcConfiguration
 * @date 2025/3/6 20:47
 */

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {



    @Autowired
    AdminLoginInterceptor adminLoginInterceptor;

    @Autowired
    AdminPermissionInterceptor adminPermissionInterceptor;


    /**
     * @description:  管理员登录拦截器配置,除了登录接口，其他全拦截。注意没有配置的情况下，先注册的拦截器先执行
     * @date: 2025/3/22 14:05
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(adminLoginInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login");
        registry.addInterceptor(adminPermissionInterceptor)
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin/login");
    }

    /**
     * 通过knife4j生成接口文档
     * @return
     */
    @Bean
    public Docket docket() {
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("邮件管理系统项目接口文档")
                .version("2.0")
                .description("邮件管理系统项目接口文档")
                .build();
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .groupName("管理端接口")
                .apiInfo(apiInfo)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.email.emailManageSystem.server.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }

    /**
     * 设置静态资源映射
     * @param registry
     */
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}