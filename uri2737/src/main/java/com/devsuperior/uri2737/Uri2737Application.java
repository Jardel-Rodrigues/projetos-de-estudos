package com.devsuperior.uri2737;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2737.dto.LawyerMinDTO;
import com.devsuperior.uri2737.projections.LawyerMinProjection;
import com.devsuperior.uri2737.repositories.LawyerRepository;

@SpringBootApplication
public class Uri2737Application implements CommandLineRunner {

	@Autowired
	private LawyerRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2737Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<LawyerMinProjection> list = repository.search1();
		List<LawyerMinDTO> result1 = list.stream().map(x -> new LawyerMinDTO(x)).toList();
		
		System.out.println("\n*** RESULTADO SQL RAIZ:");
		for (LawyerMinDTO obj : result1) {
			System.out.println(obj);
		}

	}
}
