package com.austinbv.usethisroom.acceptance.pages;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.domain.FluentWebElement;
import org.openqa.selenium.support.FindBy;

import static org.fest.assertions.fluentlenium.FluentLeniumAssertions.assertThat;

public class RoomPage extends FluentPage {
  @FindBy(css = ".info")
  private FluentWebElement informationLink;

  public void selectRoom(String room) {
    openInformation();
    fillSelect(".room").withText(room);
  }

  private void openInformation() {
    informationLink.click();
    assertThat(find(".modal")).hasText("Select A Room");
  }
}
