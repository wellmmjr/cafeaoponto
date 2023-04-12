package com.example.cafeaoponto.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.cafeaoponto.data.model.v1.Vendedor;

public interface VendedorInterface extends JpaRepository<Vendedor, Long> {

}
