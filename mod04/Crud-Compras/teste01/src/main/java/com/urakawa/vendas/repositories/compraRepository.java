package com.urakawa.vendas.repositories;

import java.util.List;

import com.urakawa.vendas.DTO.RankingComprasDTO;
import com.urakawa.vendas.entities.Compras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface compraRepository extends JpaRepository<Compras, Integer> {
  
  @Query("SELECT new com.urakawa.vendas.DTO.RankingComprasDTO(compras.cliente, SUM(compras.totalCompra)) "
      + "FROM Compras AS compras GROUP BY compras.cliente ORDER BY SUM(compras.totalCompra) DESC")
  List<RankingComprasDTO>findRanking();

}
