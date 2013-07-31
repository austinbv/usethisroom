package com.austinbv.usethisroom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/register")
public class RegistrationController {
  @Autowired
  private UserRepository userRepository;

  @RequestMapping(method = GET)
  public String registrationPage() {
    return "registration/register";
  }

  @RequestMapping(method = POST)
  public String registerUser(@RequestParam String username, @RequestParam String password) {
    User user = new User(username, password);
    userRepository.save(user);
    return "redirect:/register/success";
  }

  @RequestMapping(value = "success", method = GET)
  public String registrationsSuccess() {
    return "registration/success";
  }
}
