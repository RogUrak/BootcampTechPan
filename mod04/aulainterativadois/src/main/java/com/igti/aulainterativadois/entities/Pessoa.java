package com.igti.aulainterativadois.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_pessoa")
public class Pessoa {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(length = 350)
  private String nome;
  private String dn;
}
