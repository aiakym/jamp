package com.jamp.io.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.jamp.io.model.pojo.User;

@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan (basePackages="com.jamp.io")
public class WebConfig extends WebMvcConfigurerAdapter {
	
	@Bean
	public ViewResolver resolver() {
		InternalResourceViewResolver res = new InternalResourceViewResolver();
		res.setPrefix("/WEB-INF/view/");
		res.setSuffix(".jsp");
		return res;
	}
	
	@Bean
	@Scope(value="session", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public User registeredUser() {
		return new User();
	}
	
}
