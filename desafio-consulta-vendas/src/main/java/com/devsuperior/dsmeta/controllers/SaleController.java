package com.devsuperior.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dsmeta.dtos.SaleMaxDTO;
import com.devsuperior.dsmeta.dtos.SaleMinDTO;
import com.devsuperior.dsmeta.dtos.SaleSumDTO;
import com.devsuperior.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;

	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable @NonNull Long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	
	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleMaxDTO>> getReport(
			@RequestParam(defaultValue = "") String minDate,
			@RequestParam(defaultValue = "")String maxDate,
			@RequestParam(defaultValue = "") String name, Pageable pageable) {
		return ResponseEntity.ok(service.getReport(minDate, maxDate, name, pageable));
	}

	
	@GetMapping(value = "/summary")
	public ResponseEntity<List<SaleSumDTO>> getSummary(
			@RequestParam(name = "minDate", defaultValue = "") String minDate,
			@RequestParam(name = "maxDate", defaultValue = "") String maxDate) {
		return ResponseEntity.ok(service.getSummary(minDate, maxDate));
	}

}
