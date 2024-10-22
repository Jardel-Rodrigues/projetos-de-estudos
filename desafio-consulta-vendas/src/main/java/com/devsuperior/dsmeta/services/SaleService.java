package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dtos.SaleMaxDTO;
import com.devsuperior.dsmeta.dtos.SaleMinDTO;
import com.devsuperior.dsmeta.dtos.SaleSumDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;


@Service
public class SaleService {
	
	private LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	@Autowired
	private SaleRepository repository;

	public SaleMinDTO findById(@NonNull Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	
	public List<SaleSumDTO> getSummary(String minDate, String maxDate) {
		if(minDate.isEmpty() || maxDate.isEmpty()) {
			maxDate = today.format(formatter);
			minDate = today.minusYears(1).format(formatter);
		}
		return repository.getSummary(minDate, maxDate).stream().toList();
	}
	
	
	public Page<SaleMaxDTO> getReport(String minDate, String maxDate, String name, Pageable pageable){
		if(minDate.isEmpty() || maxDate.isEmpty()) {
			maxDate = today.format(formatter);
			minDate = today.minusYears(1).format(formatter);
		}
		return repository.getReport(minDate, maxDate, name, pageable).map(SaleMaxDTO::new);
	}

}
