package com.urakawa.login.services;

import com.urakawa.login.entities.Login;

import org.springframework.stereotype.Service;

@Service
public class LoginService {

  public String login (Login login){
    if(login.getEmail().equals("a@gmail.com")&&login.getSenha().equals("123")){
      return "logado";
    } else {
      return "erro ao logar";
    }
  }


}
