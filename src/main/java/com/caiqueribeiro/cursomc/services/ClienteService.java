package com.caiqueribeiro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiqueribeiro.cursomc.domain.Cliente;
import com.caiqueribeiro.cursomc.repositories.ClienteRepository;
import com.caiqueribeiro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente find(Integer id) {
		
		Optional<Cliente> obj = repo.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Erro: Não foi encontrado id " + id + ", Tipo: " + Cliente.class.getName()));		
		
	}

}
