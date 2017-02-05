package com.cengenes.springmvc.config;

import java.util.Locale;


import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.cengenes"})
@Import(ApplicationContext.class)
@PropertySource("classpath:application.properties")
public class WebConfig extends WebMvcConfigurerAdapter {



	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
	
		super.addViewControllers(registry);
	    
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/newblogpost.html").setViewName("newblogpost");
		registry.addViewController("/accessDenied").setViewName("accessDenied");
	
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		
	}
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		registry.addInterceptor(localeChangeInterceptor());
	}
	

	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
		
		return new PropertySourcesPlaceholderConfigurer();
		
	}
	
	@Bean
	public MessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("lang");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
		
	}
	
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor(){
		LocaleChangeInterceptor changeInterceptor= new LocaleChangeInterceptor();
		changeInterceptor.setParamName("language");
		return changeInterceptor;
		
	}
	
	@Bean
	public SessionLocaleResolver localeResolver() {
	    SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	    localeResolver.setDefaultLocale(new Locale("en", "US"));
	    return localeResolver;
	}
	
	
   @Bean
   public InternalResourceViewResolver internalResourceViewResolver(){
	   
	    InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
	    internalResourceViewResolver.setPrefix("/WEB-INF/pages/");
	    internalResourceViewResolver.setSuffix(".jsp");
        return internalResourceViewResolver;
   }
   


}


     