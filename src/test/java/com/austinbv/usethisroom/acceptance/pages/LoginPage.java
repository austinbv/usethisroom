package com.austinbv.usethisroom.acceptance.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;

import static org.fest.assertions.Assertions.assertThat;

public class LoginPage extends FluentPage {
  @FindBy(css = "input[name=j_username]")
  FluentWebElement usernameElement;
  @FindBy(css = "input[name=j_password]")
  FluentWebElement passwordElement;
  @FindBy(css = "form button[type=submit]")
  FluentWebElement loginButtonElement;

  @Override
  public String getUrl() {
    return "http://localhost:9090";
  }

  @Override
  public void isAt() {
    assertThat(title()).contains("Login");
  }

  public void login(String username, String password) {
    fill(usernameElement).with(username);
    fill(passwordElement).with(password);
    click(loginButtonElement);
  }
}
