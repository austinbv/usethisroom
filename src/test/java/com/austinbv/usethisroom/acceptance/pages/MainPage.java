package com.austinbv.usethisroom.acceptance.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;


public class MainPage extends FluentPage {
  @FindBy(css = "a#logout")
  FluentWebElement logout;

  @Override
  public String getUrl() {
    return "http://localhost:9090";
  }

  @Override
  public void isAt() {
    assertThat(find("a")).hasText("Logout");
  }

  public void logout() {
    click(logout);
  }

}
