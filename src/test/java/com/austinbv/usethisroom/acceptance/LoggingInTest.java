package com.austinbv.usethisroom.acceptance;

import com.austinbv.usethisroom.User;
import com.austinbv.usethisroom.UserRepository;
import com.austinbv.usethisroom.acceptance.pages.LoginPage;
import com.austinbv.usethisroom.acceptance.pages.MainPage;
import org.fluentlenium.core.annotation.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

public class LoggingInTest extends IntegrationBase {
  private final String password = UUID.randomUUID().toString();
  private final String username = "austinbv@gmail.com";
  @Page
  private LoginPage loginPage;
  @Page
  private MainPage mainPage;
  @Autowired
  private UserRepository userRepository;

  @BeforeClass
  public void setup() {
    User user = new User();
    user.setUsername(username);
    user.setPassword(password);
    userRepository.save(user);
  }

  @Test
  public void allowsLogin() {
    goTo(loginPage);
    loginPage.isAt();

    loginPage.login(username, password);

    mainPage.isAt();
  }

  @Test(dependsOnMethods = "allowsLogin")
  public void allowsLoggingOut() {
    mainPage.logout();
    loginPage.isAt();
  }
}
