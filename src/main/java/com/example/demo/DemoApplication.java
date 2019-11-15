package com.example.demo;

import com.example.demo.model.Client;
import com.example.demo.repo.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class DemoApplication {
	private static final Logger log = LoggerFactory.getLogger(DemoApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClientRepository clientRepository) {
		return args -> {
/*			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				Client user = new Client(" ",  name, "@domain.com");
				clientRepository.save(user);});*/
			clientRepository.findAll().forEach(System.out::println);
		};
	}
}
