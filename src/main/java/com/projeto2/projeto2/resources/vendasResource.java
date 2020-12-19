package com.projeto2.projeto2.resources;

import java.awt.print.Pageable;
import java.util.List;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.projeto2.projeto2.models.modelo_Vendas;
import com.projeto2.projeto2.repository.vendasRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value="/sistema")
@Api(value="API de Vendas - Projeto2")
@CrossOrigin(origins="*")
public class vendasResource {

	@Autowired
	vendasRepository vendasrepository;
	
	@GetMapping("/vendas")
	@ApiOperation(value="Retorna lista de vendas")
	public ResponseEntity<List<modelo_Vendas>> listaVendas(){
		//return vendasrepository.findAll();
		return ResponseEntity.ok(vendasrepository.findAll());
		
	}
	
	@GetMapping("/vendas/{id}")
	@ApiOperation(value="Retorna uma venda através do ID")
	public ResponseEntity<modelo_Vendas> listaVenda(@PathVariable(value="id") long id){
		//return vendasrepository.findById(id);
		modelo_Vendas vendas = vendasrepository.findById(id);
		return ResponseEntity.ok(vendas);
		
	}
	@Transactional
	@CacheEvict(value = "/vendas", allEntries = true)
	@PostMapping("/vendas")
	@ApiOperation(value="Grava uma venda.")
	public ResponseEntity<modelo_Vendas> modelo_vendas (@RequestBody modelo_Vendas modelo_vendas){
		return ResponseEntity.ok(vendasrepository.save(modelo_vendas));
		
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
	
	
	
	//@GetMapping("/relvendasdesc")
	@PutMapping("/vendas")
	@ApiOperation(value="Retorna vendas baseado na Descrição")
	public ResponseEntity<List<modelo_Vendas>> listaVendaDesc(@RequestParam(value="Descricao", defaultValue = "") String Descricao){
		
	//PageRequest pageRequest = PageRequest.of(1,1, Direction.valueOf("ASC"));
	
    List<modelo_Vendas> Vendas = vendasrepository.findByDescricao(Descricao);	
		
	return ResponseEntity.ok(Vendas);
		 
		
	}
}
