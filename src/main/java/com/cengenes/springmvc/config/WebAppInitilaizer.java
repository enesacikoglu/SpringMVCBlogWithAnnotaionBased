package com.cengenes.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

//@Import({ SecurityConfig.class })
public class WebAppInitilaizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		// TODO Auto-generated method stub

		/*
		 * WEB.XML BASE CONFIGRATION <servlet>
		 * <servlet-name>dispatcher</servlet-name> <servlet-class>
		 * org.springframework.web.servlet.DispatcherServlet </servlet-class>
		 * <init-param> <param-name>contextConfigLocation</param-name>
		 * <param-value>/WEB-INF/spring/dispatcher-config.xml</param-value>
		 * </init-param> <load-on-startup>1</load-on-startup> </servlet>
		 * 
		 * <servlet-mapping> <servlet-name>dispatcher</servlet-name>
		 * <url-pattern>/</url-pattern> </servlet-mapping>
		 */

		// XML BASED CONFIGRATION ON JAVA
		// XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		// appContext.setConfigLocation("/WEB-INF/spring/dispatcher-config.xml");
		/*
		 * AnnotationConfigWebApplicationContext rootContext = new
		 * AnnotationConfigWebApplicationContext();
		 * rootContext.register(WebConfig.class);
		 * 
		 * //manage life cylcle of rootcontext container.addListener(new
		 * ContextLoaderListener(rootContext)) ;
		 * 
		 * DispatcherServlet dispatcherServlet = new DispatcherServlet();
		 * ServletRegistration.Dynamic
		 * registration=container.addServlet("dispatcherServlet",
		 * dispatcherServlet); registration.setLoadOnStartup(1);
		 * registration.addMapping("/");
		 */

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebConfig.class);

		 container.addListener(new ContextLoaderListener(context));

		//DelegatingFilterProxy filterProxy = new DelegatingFilterProxy("springSecurityFilterChain");

		ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcherServlet",
				new DispatcherServlet(context)); // <-- hooray! Spring doesn't
													// look for XML files!

		//container.addFilter("springSecurityFilterChain",DelegatingFilterProxy.class)
		//.addMappingForUrlPatterns(null, false, "/*");

		// container.addFilter("springSecurityFilterChain",
		// DelegatingFilterProxy.class).addMappingForUrlPatterns(null,false,
		// "/*");
		dispatcher.setLoadOnStartup(1);
		dispatcher.addMapping("/");

	}

}
