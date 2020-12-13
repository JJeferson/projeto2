package com.projeto2.projeto2.models;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_Vendas")
public class modelo_Vendas implements Serializable{
	
private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private long id_Venda;

private BigDecimal QTDE;

private BigDecimal valorUnitario;

private BigDecimal valorTotal;

private String Descricao;



public long getId_Venda() {
	return id_Venda;
}

public void setId_Venda(long id_Venda) {
	this.id_Venda = id_Venda;
}

public BigDecimal getQTDE() {
	return QTDE;
}

public void setQTDE(BigDecimal qTDE) {
	QTDE = qTDE;
}

public BigDecimal getValorUnitario() {
	return valorUnitario;
}

public void setValorUnitario(BigDecimal valorUnitario) {
	this.valorUnitario = valorUnitario;
}

public BigDecimal getValorTotal() {
	return valorTotal;
}

public void setValorTotal(BigDecimal valorTotal) {
	this.valorTotal = valorTotal;
}

public String getDescricao() {
	return Descricao;
}

public void setDescricao(String descricao) {
	Descricao = descricao;
}


}
