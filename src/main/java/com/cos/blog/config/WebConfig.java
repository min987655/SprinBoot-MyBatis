package com.cos.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.cos.blog.config.aop.RoleIntercepter;
import com.cos.blog.config.aop.SessionIntercepter;

// 필터링
@Configuration
public class WebConfig implements WebMvcConfigurer{

	// 인터페이스 
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new SessionIntercepter())
			.addPathPatterns("/user/**") // 해당 주소는 세션인터셉터가 낚아챔
			.addPathPatterns("/post/**")
			.addPathPatterns("/post**");
		
		registry.addInterceptor(new RoleIntercepter())
			.addPathPatterns("/admin/**"); // 해당 주소는 롤인터셉터가 낚아챔
	}
	
}
