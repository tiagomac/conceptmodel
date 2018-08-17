package com.tiagomac.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.tiagomac.services.DBService;
import com.tiagomac.services.EmailService;
import com.tiagomac.services.MockEmailService;

@Configuration
@Profile("test") // notifica que todos os beans só serão ativados quando o profile ativo por test
public class TestConfig {

	@Autowired
	private DBService dbService;

	@Bean
	public boolean instantiateDatabase() throws ParseException {
		dbService.instantiateTestDatabase();
		return true;
	}

	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}

}
