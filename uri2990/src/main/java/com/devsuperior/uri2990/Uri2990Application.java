package com.devsuperior.uri2990;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devsuperior.uri2990.dto.EmpregadoDeptDTO;
import com.devsuperior.uri2990.projections.EmpregadoDeptProjection;
import com.devsuperior.uri2990.repositories.EmpregadoRepository;


@SpringBootApplication
public class Uri2990Application implements CommandLineRunner {

	@Autowired
	private EmpregadoRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2990Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		List<EmpregadoDeptProjection> list1 = repository.search1();
		List<EmpregadoDeptDTO> result1 = list1.stream().map(x -> new EmpregadoDeptDTO(x)).toList();
		
		System.out.println("\n*** RESULTADO SQL RAIZ:");
		for(EmpregadoDeptDTO obj : result1) {
			System.out.println(obj);
		}
		System.out.println("\n\n");
		
		
		List<EmpregadoDeptDTO> result2 = repository.search2();
		
		System.out.println("\n*** RESULTADO JPQL:");
		for(EmpregadoDeptDTO obj : result2) {
			System.out.println(obj);
		}
		System.out.println("\n\n");
		
	}
	
}
