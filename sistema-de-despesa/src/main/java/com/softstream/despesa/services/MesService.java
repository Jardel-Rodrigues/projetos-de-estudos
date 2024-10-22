package com.softstream.despesa.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softstream.despesa.entities.Mes;
import com.softstream.despesa.repositores.MesRepository;
import com.softstream.despesa.services.exception.ResourceNotFoundException;

@Service
public class MesService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private MesRepository repository;


	@Transactional(readOnly = true)
	public Mes findById(Long id) {
		log.info("");
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recurso não Encontrado"));
	}
	
}
