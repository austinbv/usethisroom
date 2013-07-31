package com.austinbv.usethisroom;

import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class RegistrationControllerTest {

  private static final String USERNAME = "a_username";
  private static final String PASSWORD = "password";

  @Test
  public void registerUser_createsANewUser() throws Exception {
    RegistrationController registrationController = new RegistrationController();
    UserRepository mockUserRepository = mock(UserRepository.class);
    ReflectionTestUtils.setField(registrationController, "userRepository", mockUserRepository);

    Model model = new ExtendedModelMap();
    registrationController.registerUser(USERNAME, PASSWORD, model);

    assertThat(model.asMap().get("username")).isEqualTo(USERNAME);
    verify(mockUserRepository).save(any(User.class));
  }
}
