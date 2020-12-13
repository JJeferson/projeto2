package com.projeto2.projeto2.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto2.projeto2.models.modelo_Vendas;

public interface vendasRepository extends JpaRepository<modelo_Vendas,Long> {

	
	modelo_Vendas findById(long id);
	
}
