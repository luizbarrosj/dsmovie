package com.devsuperior.dsm.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsm.dto.MovieDTO;
import com.devsuperior.dsm.services.MovieServise;

@RestController
@RequestMapping(value ="/movies")
public class MovieController {
	
	@Autowired
	private MovieServise service;
	@GetMapping
	public Page<MovieDTO> findAll(Pageable peageble){
		
		return service.findAll(peageble);
				
		
		
		
	}
	@GetMapping(value ="/{id}")
	public MovieDTO findById(@PathVariable Long id){
		
		return service.findById(id);
				
		
		
		
	}

}
