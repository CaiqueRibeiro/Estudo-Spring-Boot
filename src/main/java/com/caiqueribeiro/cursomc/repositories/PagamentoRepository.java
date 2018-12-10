package com.caiqueribeiro.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.caiqueribeiro.cursomc.domain.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Integer>{

}
