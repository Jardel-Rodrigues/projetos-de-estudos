package com.devsuperior.uri2609.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.services.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService service;

	@GetMapping("/search1")
	public ResponseEntity<List<CategorySumDTO>> search1() {
		List<CategorySumDTO> NewDto = service.search1();
		return ResponseEntity.ok(NewDto);
	}

	@GetMapping("/search2")
	public ResponseEntity<List<CategorySumDTO>> search2() {
		List<CategorySumDTO> NewDto = service.search2();
		return ResponseEntity.ok(NewDto);
	}
	
}
