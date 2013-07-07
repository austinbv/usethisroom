package com.austinbv.usethisroom.acceptance;

import com.austinbv.usethisroom.configuration.ApplicationModule;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
@ContextConfiguration(classes = {ApplicationModule.class})
public class IntegrationBase extends SpringFluent {
}
