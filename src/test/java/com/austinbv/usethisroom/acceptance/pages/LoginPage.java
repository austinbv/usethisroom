package com.austinbv.usethisroom.acceptance.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.action.FluentDefaultActions;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fest.assertions.Assertions.assertThat;

public class LoginPage extends FluentPage {
  @FindBy(css = "input[name=j_username]")
  private FluentWebElement usernameElement;
  @FindBy(css = "input[name=j_password]")
  private FluentWebElement passwordElement;
  @FindBy(css = "form button[type=submit]")
  private FluentWebElement loginButtonElement;
  @FindBy(css = ".register")
  private FluentWebElement registrationLink;

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

  public void goToRegistrationPage() {
    click(registrationLink);
  }
}
