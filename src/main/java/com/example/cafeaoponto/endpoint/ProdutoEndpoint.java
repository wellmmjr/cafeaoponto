package com.example.cafeaoponto.endpoint;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@Autowired
	private PagedResourcesAssembler<ProdutoDTO> assemble;
	

	@ApiOperation(value="Allows create Produto by this endpoint")
	@PostMapping(value = "/create", produces = {"application/json", "application/xml", "application/x-yaml"}, 
			consumes = {"application/json", "application/xml", "application/x-yaml"})
	public ProdutoDTO create(@RequestBody ProdutoDTO book){
		
		ProdutoDTO bookVO = services.createProduto(book);
		bookVO.add(linkTo(methodOn(ProdutoEndpoint.class).findById(bookVO.getKey())).withSelfRel());
		return bookVO;
		
	}


	@ApiOperation(value="Loads Produto's info by its id")
	@GetMapping(value="/{id}", produces = {"application/json"})
	private ProdutoDTO findById(@PathVariable("id" ) Long id){
		
		ProdutoDTO personVO = services.findById(id);
		personVO.add(linkTo(methodOn(ProdutoEndpoint.class).findById(id)).withSelfRel());
		return personVO;
		
	
	}
	
	@ApiOperation(value="Lists Produto's info")
	@GetMapping(value="/list", produces = {"application/json"})
	private ResponseEntity<?> findAll(
			@RequestParam(value="page", defaultValue="0") int page, 
			@RequestParam(value="limit", defaultValue="5") int limit, 
			@RequestParam(value="sort", defaultValue="asc") String sort){
		
		var sortDirection = "desc".equalsIgnoreCase(sort) ? Direction.DESC : Direction.ASC;
		
		Pageable pageable = PageRequest.of(page, limit, Sort.by(sortDirection, "nome"));
		
		Page<ProdutoDTO> persons = services.findAll(pageable);
		
		persons.stream().forEach(p ->p.add (
				linkTo(methodOn(ProdutoEndpoint.class).findById(p.getKey())).withSelfRel())
		);
		
		PagedResources<?> resources =  assemble.toResource(persons);
		
		return new ResponseEntity<>(resources, HttpStatus.OK);	
	}
}
