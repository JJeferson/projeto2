package com.projeto2.projeto2.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projeto2.projeto2.models.modelo_Vendas;

public interface vendasRepository extends JpaRepository<modelo_Vendas,Long> {

	
	modelo_Vendas findById(long id);
	
	@Query("select m from modelo_Vendas m where m.Descricao like %:Descricao%")
	
	public List<modelo_Vendas> findByDescricao(String Descricao);
	
}
