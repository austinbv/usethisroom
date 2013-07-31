package com.austinbv.usethisroom.acceptance;

import com.austinbv.usethisroom.UserRepository;
import com.austinbv.usethisroom.acceptance.pages.LoginPage;
import com.austinbv.usethisroom.acceptance.pages.MainPage;
import com.austinbv.usethisroom.acceptance.pages.RegistrationPage;
import org.fluentlenium.core.annotation.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import java.util.UUID;

import static org.fest.assertions.Assertions.assertThat;

public class LoggingInTest extends IntegrationBase {
  private static final String PASSWORD = UUID.randomUUID().toString();
  private static final String USERNAME = "austinbv@gmail.com";
  @Page
  private LoginPage loginPage;
  @Page
  private MainPage mainPage;
  @Page
  private RegistrationPage registrationPage;
  @Autowired
  private UserRepository userRepository;

  @Test
  public void registering() {
    goTo(loginPage);
    loginPage.isAt();

    loginPage.goToRegistrationPage();
    registrationPage.isAt();

    registrationPage.register(USERNAME, PASSWORD);
    assertThat(registrationPage.isOnAccountCreatedPage()).isTrue();
  }

  @Test(dependsOnMethods = "registering")
  public void allowsLogin() {
    goTo(loginPage);
    loginPage.isAt();
    loginPage.login(USERNAME, PASSWORD);

    mainPage.isAt();
  }

  @Test(dependsOnMethods = "allowsLogin")
  public void allowsLoggingOut() {
    mainPage.logout();
    loginPage.isAt();
  }
}
