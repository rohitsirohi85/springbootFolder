package com.codingshuttle.TestingApp;

import com.codingshuttle.TestingApp.services.DataService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class TestingAppApplication implements CommandLineRunner {

	private final DataService dataService;

	public static void main(String[] args) {
		SpringApplication.run(TestingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(dataService.getData());
	}
}
