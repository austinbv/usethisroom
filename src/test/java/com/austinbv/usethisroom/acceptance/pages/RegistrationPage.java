package com.austinbv.usethisroom.acceptance.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.action.FluentDefaultActions;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;

public class RegistrationPage extends FluentPage {
  private FluentWebElement username;
  private FluentWebElement password;
  @FindBy(css = ".submit")
  private FluentWebElement submitButton;
  @FindBy(css = ".account-created")
  private FluentWebElement accountCreatedHeadline;

  public String getUrl() {
    return "http://localhost:9090/register";
  }

  @Override
  public void isAt() {
    assertThat(find("h1")).hasText("Register");
  }

  public void register(String username, String password) {
    fill(this.username).with(username);
    fill(this.password).with(password);
    click(submitButton);
  }

  public boolean isOnAccountCreatedPage() {
    return accountCreatedHeadline.isDisplayed();
  }
}
