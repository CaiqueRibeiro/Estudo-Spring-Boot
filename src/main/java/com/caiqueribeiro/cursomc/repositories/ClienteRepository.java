package com.caiqueribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiqueribeiro.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

}
