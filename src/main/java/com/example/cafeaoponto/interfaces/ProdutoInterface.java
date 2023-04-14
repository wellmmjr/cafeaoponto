package com.example.cafeaoponto.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeaoponto.data.model.v1.Produto;

public interface ProdutoInterface extends JpaRepository<Produto, Long>{

	

}
