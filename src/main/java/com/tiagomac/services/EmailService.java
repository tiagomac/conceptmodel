package com.tiagomac.services;

import org.springframework.mail.SimpleMailMessage;

import com.tiagomac.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
