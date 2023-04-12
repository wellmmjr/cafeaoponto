package com.example.cafeaoponto.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeaoponto.data.model.v1.Venda;

public interface VendaInterface extends JpaRepository<Venda, Long> {

}
