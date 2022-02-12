package com.urakawa.pessoa.entities;

public class Pessoa {
  private String cpf;
  private String nome;
  private String dn;
  
  public Pessoa(String cpf, String nome, String dn) {
    this.cpf = cpf;
    this.nome = nome;
    this.dn = dn;
  }
  public String getCpf() {
    return cpf;
  }
  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getDn() {
    return dn;
  }
  public void setDn(String dn) {
    this.dn = dn;
  }
}
