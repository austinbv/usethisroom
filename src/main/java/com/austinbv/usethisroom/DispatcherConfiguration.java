package com.austinbv.usethisroom;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class DispatcherConfiguration {
  @Bean
  public InternalResourceViewResolver internalResourceViewResolver() {
    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
    resolver.setPrefix("/WEB-INF/pages/");
    resolver.setSuffix(".jsp");
    return resolver;
  }
}
