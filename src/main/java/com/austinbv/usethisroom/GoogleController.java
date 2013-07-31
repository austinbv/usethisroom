package com.austinbv.usethisroom;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/google")
public class GoogleController {
  @Resource
  GoogleService googleService;

  @RequestMapping("code")
  public String getCode() {
    return "redirect:" + googleService.code_url();
  }
}