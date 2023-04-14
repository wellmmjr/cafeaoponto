package com.example.cafeaoponto.data.model.v1;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="venda")
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
	
	@Column(name="valorTotalCompra", nullable = false)
	private Double valorTotalCompra;

}
