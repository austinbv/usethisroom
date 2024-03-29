package com.austinbv.usethisroom.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan("com.austinbv.usethisroom")
@ImportResource({"classpath*:security.xml"})
public class ApplicationModule {
}
