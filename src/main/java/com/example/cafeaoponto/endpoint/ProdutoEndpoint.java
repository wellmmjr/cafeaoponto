package com.example.cafeaoponto.endpoint;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cafeaoponto.data.transfer.object.ProdutoDTO;
import com.example.cafeaoponto.services.ProdutoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Produto Endpoints", description = "Accepts and provides entity Produto' json contents", 
tags= {"Produto Endpoints", "Produto"})
@RestController
@RequestMapping("/api/Produto/v1")
public class ProdutoEndpoint {

	@Autowired
	private ProdutoService services;
	

	@ApiOperation(value="Allows create Produto by this endpoint")
	@PostMapping(value = "/create", produces = {"application/json", "application/xml", "application/x-yaml"}, 
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public ProdutoDTO create(@RequestBody ProdutoDTO book){
		
		ProdutoDTO bookVO = services.createProduto(book);
		bookVO.add(linkTo(methodOn(ProdutoEndpoint.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
		
	}
}
