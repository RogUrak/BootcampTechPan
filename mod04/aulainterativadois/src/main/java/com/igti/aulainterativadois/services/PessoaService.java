package com.igti.aulainterativadois.services;

import java.util.List;

import com.igti.aulainterativadois.entities.Pessoa;
import com.igti.aulainterativadois.repositories.PessoaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {
  
  @Autowired
  private PessoaRepository pessoaRepository;

  public Pessoa savePessoa(Pessoa pessoa){
    pessoaRepository.save(pessoa);
    return pessoa;
  }

  public List<Pessoa>findAll(){
    List<Pessoa>res = pessoaRepository.findAll();
    return res;
  }
}
