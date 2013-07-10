package com.austinbv.usethisroom;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;

@Document
public class User {
  @Id
  private String id;
  private String username;
  private String password;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    PlaintextPasswordEncoder plaintextPasswordEncoder = new PlaintextPasswordEncoder();
    this.password = plaintextPasswordEncoder.encodePassword(password, null);
  }
}
