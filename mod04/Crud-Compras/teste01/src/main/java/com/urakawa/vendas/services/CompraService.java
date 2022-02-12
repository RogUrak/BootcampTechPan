package com.urakawa.vendas.services;

import java.util.List;
import java.util.stream.Collectors;

import com.urakawa.vendas.DTO.ComprasDTO;
import com.urakawa.vendas.DTO.RankingComprasDTO;
import com.urakawa.vendas.entities.Cliente;
import com.urakawa.vendas.entities.Compras;
import com.urakawa.vendas.repositories.clienteRepository;
import com.urakawa.vendas.repositories.compraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
public class CompraService {
  
  @Autowired
  private compraRepository compraRepository;

  @Autowired
  private clienteRepository clienteRepository;

  public List<ComprasDTO> findAll(){
    clienteRepository.findAll();
    List<Compras>res = compraRepository.findAll();
    return res.stream().map(c -> new ComprasDTO(c)).collect(Collectors.toList());
  }

  public List<RankingComprasDTO> findRanking(){
    List<RankingComprasDTO>res = compraRepository.findRanking();
    return res;
  }

  public Compras saveCompras(Compras compras){
    return compraRepository.save(compras);
  }

  public Compras updateCompras (Integer id, Compras newCompras){
    return compraRepository.findById(id).map(c -> {
      c.setTotalCompra(newCompras.getTotalCompra());
      c.setDataCompra(newCompras.getDataCompra());
      Compras atualizado = compraRepository.save(c);
      return atualizado;
    }).orElse(null);
  }

  public void deleteCompras(Integer id){
    try{
      if(compraRepository.findById(id) != null)
        compraRepository.deleteById(id);
    }catch(DataIntegrityViolationException e){
      throw new DataIntegrityViolationException("Você não pode deletar um cliente que fez compras");
    }
  }

  public Compras fromDTO(ComprasDTO comprasDTO){
    Compras entidade = new Compras(0, comprasDTO.getTotalCompra(), comprasDTO.getDataCompra(), new Cliente(comprasDTO.getCliente().getId(), null, null));
    return entidade;
  }

}
