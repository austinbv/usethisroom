package com.austinbv.usethisroom;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan("com.austinbv.usethisroom")
@ImportResource( { "classpath*:security.xml" } )
public class ApplicationModule {

}
