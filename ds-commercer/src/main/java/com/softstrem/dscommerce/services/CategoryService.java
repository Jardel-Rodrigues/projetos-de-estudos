package com.softstrem.dscommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.softstrem.dscommerce.dto.CategoryDTO;
import com.softstrem.dscommerce.entities.Category;
import com.softstrem.dscommerce.repositories.CategotyRepository;

@Service
public class CategoryService {

	@Autowired
	private CategotyRepository repository;

	@Transactional(readOnly = true)
	public List<CategoryDTO> findAll() {
		List<Category> result = repository.findAll();
		return result.stream().map(x -> new CategoryDTO(x)).toList();

	}

}
