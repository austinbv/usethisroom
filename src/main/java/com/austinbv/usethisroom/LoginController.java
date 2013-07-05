package com.austinbv.usethisroom;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Controller
@RequestMapping("/")
public class LoginController {
  @RequestMapping(method = GET)
  public String homePage() {
    return "homePage";
  }

  @RequestMapping(value="login", method = GET)
  public String loginPage() {
    return "login";
  }
}