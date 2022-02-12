package com.urakawa.vendas.controllers;

import java.util.List;

import com.urakawa.vendas.DTO.ComprasDTO;
import com.urakawa.vendas.DTO.RankingComprasDTO;
import com.urakawa.vendas.entities.Compras;
import com.urakawa.vendas.services.CompraService;

import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/compras")
public class comprasController {
  
  @Autowired
  private CompraService compraService;

  @GetMapping
  public ResponseEntity<List<ComprasDTO>>findAll(){
    List<ComprasDTO>lista = compraService.findAll();
    return ResponseEntity.ok(lista);
  }

  @GetMapping("/ranking-cliente-por-compras")
  public ResponseEntity<List<RankingComprasDTO>>findRanking(){
    List<RankingComprasDTO>lista = compraService.findRanking();
    return ResponseEntity.ok(lista);
  }

  @PostMapping
  @ResponseBody
  public ResponseEntity<ComprasDTO>saveCompras(@RequestBody ComprasDTO comprasDTO){
    Compras entidade = compraService.fromDTO(comprasDTO);
    compraService.saveCompras(entidade);
    return new ResponseEntity<ComprasDTO>(comprasDTO, HttpStatus.CREATED);
  }

  @PutMapping(path = "/{id}")
  @ResponseBody
  public ResponseEntity<ComprasDTO>updateCompras(@PathVariable Integer id, @RequestBody ComprasDTO comprasDTO){
    Compras entidade = compraService.fromDTO(comprasDTO);
    if (compraService.updateCompras(id, entidade) != null){
      return new ResponseEntity<ComprasDTO>(comprasDTO, HttpStatus.OK);
    }
    return ResponseEntity.notFound().build();
  }

  @DeleteMapping(path = "/{id}")
  public ResponseEntity<Void> deleteCompras(@PathVariable Integer id){
    compraService.deleteCompras(id);
    return ResponseEntity.noContent().build();
  }

}
