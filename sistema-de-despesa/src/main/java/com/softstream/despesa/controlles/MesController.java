package com.softstream.despesa.controlles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softstream.despesa.entities.Mes;
import com.softstream.despesa.services.MesService;

@RestController
@RequestMapping(value = "/mes")
public class MesController {
	
	private static final Logger log = LoggerFactory.getLogger(MesController.class);

	@Autowired
	private MesService service;

	@GetMapping(value = "/{id}", produces = "application/json")
	public ResponseEntity<Mes> findById(@PathVariable Long id) {
		Mes mes = service.findById(id);
		log.info("");
		return ResponseEntity.ok().body(mes);
	}

}
