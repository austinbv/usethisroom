package com.austinbv.usethisroom.acceptance;

import com.austinbv.usethisroom.acceptance.pages.LoginPage;
import com.austinbv.usethisroom.acceptance.pages.MainPage;
import org.fluentlenium.adapter.FluentTestNg;
import org.fluentlenium.adapter.util.SharedDriver;
import org.fluentlenium.core.annotation.Page;
import org.testng.annotations.Test;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;

@SharedDriver(type = SharedDriver.SharedType.ONCE)
public class LoggingIn extends FluentTestNg {
  @Page
  LoginPage loginPage;
  @Page
  MainPage mainPage;

  @Test
  public void allowsLogin() {
    goTo(loginPage);
    loginPage.isAt();
    loginPage.login("austinbv@gmail.com", "123456");

    mainPage.isAt();
  }

  @Test(dependsOnMethods = "allowsLogin")
  public void allowsLoggingOut() {
    mainPage.logout();
    loginPage.isAt();
  }
}
