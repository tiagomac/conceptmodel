package com.tiagomac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.tiagomac.services.S3Service;

@SpringBootApplication
public class ConceptmodelApplication implements CommandLineRunner {
	
	@Autowired
	private S3Service s3service;

	public static void main(String[] args) {
		SpringApplication.run(ConceptmodelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		s3service.uploadFile("C:\\temp\\fotos\\ana.jpg");
	}
}
