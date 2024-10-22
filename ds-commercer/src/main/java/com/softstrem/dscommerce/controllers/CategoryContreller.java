package com.softstrem.dscommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softstrem.dscommerce.dto.CategoryDTO;
import com.softstrem.dscommerce.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
@CrossOrigin(origins = "*")
public class CategoryContreller {

	@Autowired
	private CategoryService service;

	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll() {
		List<CategoryDTO> dto = service.findAll();
		return ResponseEntity.ok(dto);
	}

}
