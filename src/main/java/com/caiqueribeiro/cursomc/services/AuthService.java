package com.caiqueribeiro.cursomc.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.caiqueribeiro.cursomc.domain.Cliente;
import com.caiqueribeiro.cursomc.repositories.ClienteRepository;
import com.caiqueribeiro.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private EmailService emailService;
	
	private Random rand = new Random();
	
	public void sendNewPassword(String email) {
		
		Cliente cliente = clienteRepository.findByEmail(email);
		
		if(cliente == null) {
			throw new ObjectNotFoundException("E-mail não encontrado.");
		}
		
		String newPass = this.newPassword();
		cliente.setSenha(pe.encode(newPass));
		
		clienteRepository.save(cliente);
		
		emailService.sendNewPasswordEmail(cliente, newPass);
	}
	
	public String newPassword() {
		char[] vet = new char[10];
		
		for(int i = 0; i < 10; i++) {
			vet[i] = this.randomChar();
		}		
		return new String(vet);
	}
	
	public char randomChar() {
		int opt = rand.nextInt(3);
		
		if(opt == 0) {
			return (char) (rand.nextInt(10) + 48);
		}
		
		if(opt == 1) {
			return (char) (rand.nextInt(26) + 65);
		}
		
		return (char) (rand.nextInt(26) + 97);
	}

}
