package com.caiqueribeiro.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caiqueribeiro.cursomc.domain.Categoria;
import com.caiqueribeiro.cursomc.repositories.CategoriaRepository;
import com.caiqueribeiro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer id) {

		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Erro: Não foi encontrado id " + id + ", Tipo: " + Categoria.class.getName()));
	}

}
