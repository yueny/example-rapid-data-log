package com.rapid.example.data.log.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yueny.rapid.data.log.trace.web.filter.mdc.WebLogMdcHandlerInterceptor;

/**
 * 安全拦截器配置
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(new WebLogMdcHandlerInterceptor()).addPathPatterns("/").addPathPatterns("/**");
	}

}
