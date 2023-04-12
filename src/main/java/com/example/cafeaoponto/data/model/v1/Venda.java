package com.example.cafeaoponto.data.model.v1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Venda implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="comanda", nullable = false)
	private Long comanda;
	
	@Column(name="qtdEstoque", nullable = false)
	private int qtdEstoque;
	
	@Column(name="precoUnidade", nullable = false)
	private Double precoUnidade;

}
