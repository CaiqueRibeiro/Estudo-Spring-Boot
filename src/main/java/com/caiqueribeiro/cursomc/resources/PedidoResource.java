package com.caiqueribeiro.cursomc.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.caiqueribeiro.cursomc.domain.Pedido;
import com.caiqueribeiro.cursomc.services.PedidoService;

@Controller
@RequestMapping(value="/pedidos")
public class PedidoResource {
	
	@Autowired
	PedidoService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		Pedido obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
		
	}

}
