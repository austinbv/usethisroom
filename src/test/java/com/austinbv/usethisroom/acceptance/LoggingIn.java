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

public class LoggingIn extends IntegrationBase {
  @Page
  private LoginPage loginPage;
  @Page
  private MainPage mainPage;
  @Autowired
  private UserRepository userRepository;

  @BeforeClass
  public void setup() {
    User user = new User();
    user.setUsername("austinbv@gmail.com");
    user.setPassword(UUID.randomUUID().toString());
    userRepository.save(user);
  }

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
