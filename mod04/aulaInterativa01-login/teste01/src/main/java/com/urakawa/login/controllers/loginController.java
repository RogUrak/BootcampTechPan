package com.urakawa.login.controllers;

import com.urakawa.login.entities.Login;
import com.urakawa.login.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class loginController {

  @Autowired
  private LoginService loginService;

  @PostMapping("")
  @ResponseBody
  public String login (@RequestBody Login login) {
    return loginService.login(login);
  }
}
