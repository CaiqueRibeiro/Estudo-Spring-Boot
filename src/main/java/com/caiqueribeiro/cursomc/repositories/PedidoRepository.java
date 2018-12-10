package com.caiqueribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiqueribeiro.cursomc.domain.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Integer>{

}
