package com.austinbv.usethisroom;

public class GoogleAccess {
  private String accessToken;
  private String refreshToken;

  public GoogleAccess(String accessToken, String refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }

  public String getRefreshToken() {
    return refreshToken;
  }

  public String getAccessToken() {
    return accessToken;
  }
}
