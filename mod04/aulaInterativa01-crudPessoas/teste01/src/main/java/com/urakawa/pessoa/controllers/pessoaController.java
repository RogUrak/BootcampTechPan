package com.urakawa.pessoa.controllers;

import java.util.ArrayList;
import java.util.List;

import com.urakawa.pessoa.entities.Pessoa;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pessoas")
public class pessoaController {

  List<Pessoa>listaPessoa = new ArrayList<Pessoa>();

  @GetMapping("")
  public ResponseEntity<List<Pessoa>>findAll(){
    return ResponseEntity.ok(listaPessoa);
  }

  @PostMapping("")
  @ResponseBody
  public ResponseEntity<Pessoa>savePessoa(@RequestBody Pessoa newPessoa){
    listaPessoa.add(newPessoa);
    return new ResponseEntity<Pessoa>(newPessoa, HttpStatus.CREATED);
  }

  @DeleteMapping(value = "/{cpf}")
  public void deletePessoa(@PathVariable String cpf){
    listaPessoa.removeIf(p -> cpf.equals(p.getCpf()));
  }

  @PutMapping(value = "/{cpf}")
  @ResponseBody
  public ResponseEntity<String>updatePessoa(@PathVariable String cpf, @RequestBody Pessoa p){
    for(int i=0; i<listaPessoa.size(); i++){
      if(listaPessoa.get(i).getCpf().equals(cpf)){
        listaPessoa.set(i, p);
        return new ResponseEntity<String>("Atualizado", HttpStatus.OK);
      }
    }
    return new ResponseEntity<String>("ERRO", HttpStatus.BAD_REQUEST);
  }

}
