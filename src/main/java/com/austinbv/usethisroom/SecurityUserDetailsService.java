package com.austinbv.usethisroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class SecurityUserDetailsService implements UserDetailsService {
  @Autowired
  private UserRepository userRepository;
  private static final ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>(Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = userRepository.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("Could Not Find User: " + username);
    }

    return convertUserToUserDetails(user);
  }

  private UserDetails convertUserToUserDetails(User user) {
    return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
  }
}
