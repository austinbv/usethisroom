package com.austinbv.usethisroom.test.integration;

import org.fluentlenium.adapter.FluentTestNg;
import org.fluentlenium.adapter.util.SharedDriver;
import org.testng.annotations.Test;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;

@SharedDriver(type = SharedDriver.SharedType.ONCE)
public class HelloWorldTest extends FluentTestNg {
  @Test
  public void theHomePage() {
    goTo("http://localhost:9090");
    assertThat(find("body")).hasText("hello!");
  }
}
