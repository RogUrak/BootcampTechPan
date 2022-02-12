package com.igti.aulainterativadois.repositories;

import com.igti.aulainterativadois.entities.Pessoa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer>{
  
}
