package com.softstrem.desafio;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.softstrem.desafio.entities.Order;
import com.softstrem.desafio.services.OrderService;

@SpringBootApplication
public class Desafio1Application implements CommandLineRunner {
	
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(Desafio1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Locale.setDefault(Locale.US);
		Scanner input = new Scanner(System.in);
		
		int code = input.nextInt();
		double basic = input.nextDouble();
		double discount = input.nextDouble();
		
		Order order = new Order(code, basic, discount);
		
		double total = orderService.total(order);
		
		System.out.println("Pedido código " + code);
		System.out.println(String.format("Valor total: R$ %.2f", total));
		
input.close();		
	}

}
