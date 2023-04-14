package com.example.cafeaoponto.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import com.example.cafeaoponto.data.model.v1.Produto;
import com.example.cafeaoponto.data.transfer.object.ProdutoDTO;
import com.example.cafeaoponto.interfaces.ProdutoInterface;
import com.example.cafeaoponto.serialization.converter.DozerConverter;

public class ProdutoService {

	
	@Autowired
	ProdutoInterface repository;
	
	
	public ProdutoDTO createProduto(ProdutoDTO book) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ProdutoDTO findById(Long id) {

		var entity = repository.findById(id).
				orElseThrow(() -> new ResourceNotFoundException("no records found for this id")) ;
		return DozerConverter.parseObject(entity, ProdutoDTO.class);
	}
	
	public Page<ProdutoDTO> findAll(Pageable pageable) {
		
		var page = repository.findAll(pageable);
		return page.map(this::convertToProdutoDTO);
	}
	
	public List<ProdutoDTO> findAllPaged() {
		
		return DozerConverter.parseListObjects(repository.findAll(), ProdutoDTO.class);
	}
	
	private ProdutoDTO convertToProdutoDTO(Produto entity) {
		return DozerConverter.parseObject(entity, ProdutoDTO.class);
	}
	
	

}
