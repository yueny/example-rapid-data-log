package com.rapid.example.dubbo.consumer.filter;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yueny.rapid.adapter.digest.web.interceptor.DigestLogHandlerInterceptor;
import com.yueny.rapid.data.log.trace.web.filter.mdc.WebLogMdcHandlerInterceptor;

/**
 * 安全拦截器配置
 */
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {
	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(new WebLogMdcHandlerInterceptor()).addPathPatterns("/**");

		// final WebDigestLogHandlerInterceptor digestLogHandlerInterceptor =
		// new WebDigestLogHandlerInterceptor("SLOWLY-DIGEST-LOGGER");
		// digestLogHandlerInterceptor.setPrintDigstPigeonhole(true);
		// digestLogHandlerInterceptor.setSlowDumpThreshold(1000L);
		//
		// registry.addInterceptor(digestLogHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/error");

		final DigestLogHandlerInterceptor digestLogHandlerInterceptor = new DigestLogHandlerInterceptor(
				"SLOWLY-DIGEST-LOGGER");
		digestLogHandlerInterceptor.setPrintDigstPigeonhole(true);
		digestLogHandlerInterceptor.setSlowDumpThreshold(1000L);

		registry.addInterceptor(digestLogHandlerInterceptor).addPathPatterns("/**").excludePathPatterns("/error");
	}

}
