package com.austinbv.usethisroom.acceptance;

import com.austinbv.usethisroom.configuration.ApplicationModule;
import com.austinbv.usethisroom.fakes.SpringFluent;
import org.fluentlenium.adapter.util.SharedDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.BeforeClass;

@WebAppConfiguration
@ContextConfiguration(classes = {ApplicationModule.class})
@SharedDriver(type = SharedDriver.SharedType.ONCE)
@ActiveProfiles("integration-test")
public class IntegrationBase extends SpringFluent {
  @Autowired
  private AbstractMongoConfiguration mongoConfiguration;

  @BeforeClass
  public void setUp() throws Exception {
    mongoConfiguration.mongoDbFactory().getDb().dropDatabase();
  }
}
