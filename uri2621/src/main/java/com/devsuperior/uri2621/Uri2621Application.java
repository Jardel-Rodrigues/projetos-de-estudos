package com.devsuperior.uri2621;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.entities.projections.ProductMinProjection;
import com.devsuperior.uri2621.repositories.ProductRepository;

@SpringBootApplication
public class Uri2621Application implements CommandLineRunner {

	@Autowired
	private ProductRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2621Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<ProductMinProjection> list = repository.search1(10, 20, "P");
		List<ProductMinDTO> result1 = list.stream().map(x -> new ProductMinDTO(x)).toList();
		
		System.out.println("\n*** RESULTADO DO SQL RAIZ:");
		for(ProductMinDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n\n");
		
		
		List<ProductMinDTO> result2 = repository.search2(10, 20, "P");
	
		System.out.println("\n*** RESULTADO JPQL:");
		for(ProductMinDTO obj : result2) {
			System.out.println(obj);
		}
		
	}
}
