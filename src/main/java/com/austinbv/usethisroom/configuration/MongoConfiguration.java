package com.austinbv.usethisroom.configuration;

import com.mongodb.Mongo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = {"com.austinbv.usethisroom"})
public class MongoConfiguration extends AbstractMongoConfiguration {
  @Override
  protected String getDatabaseName() {
    return "usethisroom";
  }

  @Override
  @Bean
  public Mongo mongo() throws Exception {
    return new Mongo("127.0.0.1");
  }

  @Override
  protected String getMappingBasePackage() {
    return "com.austinbv.usethisroom";
  }
}
