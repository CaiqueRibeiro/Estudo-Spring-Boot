package com.caiqueribeiro.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.caiqueribeiro.cursomc.domain.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	void sendEmail(SimpleMailMessage msg);

}
