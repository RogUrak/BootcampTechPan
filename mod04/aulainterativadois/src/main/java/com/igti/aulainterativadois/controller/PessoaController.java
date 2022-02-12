package com.igti.aulainterativadois.controller;

import java.util.List;

import com.igti.aulainterativadois.entities.Pessoa;
import com.igti.aulainterativadois.services.PessoaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/pessoas")
public class PessoaController {

  @Autowired
  private PessoaService pessoaService;

  @PostMapping
  @ResponseBody
  public ResponseEntity<Pessoa> savePessoa(@RequestBody Pessoa p){
    pessoaService.savePessoa(p);
    return new ResponseEntity<Pessoa>(p, HttpStatus.CREATED);
  }

  @GetMapping("")
  public ResponseEntity<List<Pessoa>> findAll(){
    List<Pessoa>lista = pessoaService.findAll();
    return ResponseEntity.ok(lista);
  }

}
