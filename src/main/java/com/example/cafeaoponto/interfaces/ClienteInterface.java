package com.example.cafeaoponto.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.cafeaoponto.data.model.v1.Cliente;


public interface ClienteInterface extends JpaRepository<Cliente, Long>{

	@Modifying
	@Query("UPDATE Cliente c SET c.enabled = false WHERE c.id = :id")
	void disablePersons(@Param("id") Long id);
	
	@Query("SELECT c FROM Cliente c WHERE c.firstName LIKE LOWER ( CONCAT ( :firstName,'%' ) )")
	Page<Cliente> findPersonByName(@Param("firstName") String firstName, Pageable pageable);
	
}
