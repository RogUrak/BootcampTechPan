package com.urakawa.vendas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.urakawa.vendas.entities.Cliente;

@Repository
public interface clienteRepository extends JpaRepository<Cliente, Integer> {

}
