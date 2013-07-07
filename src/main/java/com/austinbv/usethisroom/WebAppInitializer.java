package com.austinbv.usethisroom;

import com.austinbv.usethisroom.configuration.ApplicationModule;
import com.austinbv.usethisroom.configuration.DispatcherModule;
import com.austinbv.usethisroom.configuration.MongoConfiguration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

@SuppressWarnings("unused")
public class WebAppInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext container) {
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    rootContext.register(ApplicationModule.class);
    container.addListener(new ContextLoaderListener(rootContext));

    AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
    dispatcherContext.register(DispatcherModule.class);
    dispatcherContext.register(MongoConfiguration.class);

    container.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain"))
      .addMappingForUrlPatterns(null, false, "/*");

    ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherContext));
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping("/");
  }
}
