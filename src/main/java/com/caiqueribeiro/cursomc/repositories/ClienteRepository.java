package com.caiqueribeiro.cursomc.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiqueribeiro.cursomc.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	@Transactional
	Cliente findByEmail(String email);

}
