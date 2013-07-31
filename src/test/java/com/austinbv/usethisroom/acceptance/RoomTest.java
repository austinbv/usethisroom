package com.austinbv.usethisroom.acceptance;

import com.austinbv.usethisroom.User;
import com.austinbv.usethisroom.UserRepository;
import com.austinbv.usethisroom.acceptance.pages.LoginPage;
import com.austinbv.usethisroom.acceptance.pages.RoomPage;
import org.fluentlenium.core.annotation.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class RoomTest extends IntegrationBase {
  private static final String PASSWORD = "a password";
  private static final String USERNAME = "austinbv";

  @Autowired
  UserRepository userRepository;
  @Page
  private LoginPage loginPage;
  @Page
  private RoomPage roomPage;

  @Test
  public void setUp() {
    User user = new User(USERNAME, PASSWORD);
    userRepository.save(user);
    loginPage.login(USERNAME, PASSWORD);
  }

  @Test(dependsOnMethods = "setUp")
  public void usersCanSelectARoomToTrack() {
    roomPage.selectRoom("West");
  }
}
