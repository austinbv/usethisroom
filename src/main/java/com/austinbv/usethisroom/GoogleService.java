package com.austinbv.usethisroom;

import org.resthub.web.Client;
import org.resthub.web.Http;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriUtils;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Service
public class GoogleService {
  @Value("${google.client_id}")
  public String client_id;
  Client httpClient = new Client();
  @Value("${google.client_secret}")
  private String client_secret;
  @Value("${google.redirect_uri}")
  private String redirect_uri;

  public String code_url() {
    return "https://accounts.google.com/o/oauth2/auth?" +
      "scope=" +
      encode("https://www.googleapis.com/auth/calendar.readonly") + "+" +
      encode("https://www.googleapis.com/auth/userinfo.email") + "&" +
      "state=%2Fprofile&" +
      "redirect_uri=" + encode(redirect_uri) + "&" +
      "response_type=code&" +
      "client_id=" + encode(client_id) + "&" +
      "access_type=offline&" +
      "approval_prompt=force";
  }

  public GoogleAccess getAccess(String code) {
    String body =
      "code=" + encode(code) + "&" +
        "client_id=" + encode(client_id) + "&" +
        "client_secret=" + encode(client_secret) + "&" +
        "redirect_uri=" + encode(redirect_uri) + "&" +
        "grant_type=authorization_code";

    HashMap<String, String> s = httpClient.url("https://accounts.google.com/o/oauth2/token")
      .setHeader(Http.CONTENT_TYPE, Http.FORM)
      .post(body)
      .resource(HashMap.class);

    return new GoogleAccess(s.get("access_token"), s.get("refresh_token"));
  }

  public String getUserID(GoogleAccess access) {
    Map<String, String> map = httpClient.url("https://www.googleapis.com/oauth2/v1/userinfo")
      .setQueryParameter("access_token", encode(access.getAccessToken()))
      .get().resource(HashMap.class);

    return map.get("id");
  }

  public Map getUserInfo(GoogleAccess access) {
    Map<String, String> map = httpClient.url("https://www.googleapis.com/oauth2/v1/userinfo")
      .setQueryParameter("access_token", encode(access.getAccessToken()))
      .get().resource(HashMap.class);

    return map;
  }

  public String getAccessTokenFromRefresh(String refresh_token) {
    String body = "client_id=" + encode(client_id) + "&" +
      "client_secret=" + encode(client_secret) + "&" +
      "refresh_token=" + encode(refresh_token) + "&" +
      "grant_type=refresh_token";

    HashMap<String, String> s = httpClient.url("https://accounts.google.com/o/oauth2/token")
      .setHeader(Http.CONTENT_TYPE, Http.FORM)
      .post(body)
      .resource(HashMap.class);
    return s.get("access_token");
  }

  private String encode(String s) {
    try {
      return UriUtils.encodePathSegment(s, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      throw new RuntimeException();
    }
  }
}
