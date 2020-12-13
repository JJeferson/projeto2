package com.projeto2.projeto2.resources;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto2.projeto2.models.modelo_Vendas;
import com.projeto2.projeto2.repository.vendasRepository;

@RestController
@RequestMapping(value="sistema")
public class vendasResource {

	@Autowired
	vendasRepository vendasrepository;
	
	@GetMapping("/vendas")
	public List<modelo_Vendas> listaVendas(){
		return vendasrepository.findAll();
		
	}
	
	@GetMapping("/vendas/{id}")
	public modelo_Vendas listaVenda(@PathVariable(value="id") long id){
		return vendasrepository.findById(id);
		
	}
	@Transactional
	@CacheEvict(value = "/vendas", allEntries = true)
	@PostMapping("/vendas")
	public modelo_Vendas modelo_vendas (@RequestBody modelo_Vendas modelo_vendas){
		return vendasrepository.save(modelo_vendas);
		
		/*
		Exemplo de Json para POST
         
         {
         "qtde":1,
		 "valorUnitario":1,
		 "valorTotal":1,
		 "descricao":"emailteste@teste.com.br"
		 }
		
		 */
		
	}
}
