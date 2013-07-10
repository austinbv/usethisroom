package com.austinbv.usethisroom.unit;

import com.austinbv.usethisroom.SecurityUserDetailsService;
import com.austinbv.usethisroom.User;
import com.austinbv.usethisroom.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.util.ReflectionTestUtils;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SecurityUserDetailsServiceTest {

  private static final String USERNAME = "a_user_name";
  private static final String SOME_PASSWORD = "some_password";

  @Test
  public void loadUserByUsername_FindsAUserByTheirName() throws Exception {
    SecurityUserDetailsService securityUserDetailsService = new SecurityUserDetailsService();
    User user = new User();
    user.setUsername(USERNAME);
    user.setPassword(SOME_PASSWORD);

    UserRepository mockUserRepository = mock(UserRepository.class);
    when(mockUserRepository.findByUsername(USERNAME)).thenReturn(user);

    ReflectionTestUtils.setField(securityUserDetailsService, "userRepository", mockUserRepository);

    UserDetails loadedUser = securityUserDetailsService.loadUserByUsername(USERNAME);
    assertThat(loadedUser.getUsername()).isEqualTo(USERNAME);
    assertThat(loadedUser.getPassword()).isEqualTo(SOME_PASSWORD);
  }

  @Test(expectedExceptions = UsernameNotFoundException.class)
  public void loadUserByUsername_RaisesAUserNotFoundExceptionWhenNoUserIsFound() {
    UserRepository mockUserRepository = mock(UserRepository.class);
    when(mockUserRepository.findByUsername(USERNAME)).thenReturn(null);
    SecurityUserDetailsService securityUserDetailsService = new SecurityUserDetailsService();
    ReflectionTestUtils.setField(securityUserDetailsService, "userRepository", mockUserRepository);

    securityUserDetailsService.loadUserByUsername(USERNAME);
  }
}
