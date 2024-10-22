package com.devsuperior.uri2609.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.uri2609.dto.CategorySumDTO;
import com.devsuperior.uri2609.projections.CategorySumProjection;
import com.devsuperior.uri2609.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	public List<CategorySumDTO> search1 (){
		List<CategorySumProjection> list = repository.search1();
		List<CategorySumDTO> result1 = list.stream().map(x -> new CategorySumDTO(x)).toList();
		return result1;
	}
	
	public List<CategorySumDTO> search2 (){
		List<CategorySumDTO> result2 = repository.search2();
		return result2;
	}

}
