package com.caiqueribeiro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiqueribeiro.cursomc.domain.Pedido;
import com.caiqueribeiro.cursomc.repositories.PedidoRepository;
import com.caiqueribeiro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	public Pedido buscar(Integer id) {
		
		Optional<Pedido> obj = repo.findById(id);		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Erro: Não foi encontrado id " + id + ", Tipo: " + Pedido.class.getName()));
		
	}
	
}
