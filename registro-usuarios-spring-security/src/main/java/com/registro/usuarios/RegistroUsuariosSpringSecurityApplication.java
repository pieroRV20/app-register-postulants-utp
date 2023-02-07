package com.registro.usuarios;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.registro.usuarios.model.Evaluator;
import com.registro.usuarios.repository.IEvaluatorRepository;

@SpringBootApplication
public class RegistroUsuariosSpringSecurityApplication implements CommandLineRunner {
	
	@Autowired
	private  IEvaluatorRepository evaluatorRepository;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	
	public static void main(String[] args) {
		SpringApplication.run(RegistroUsuariosSpringSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		@SuppressWarnings("deprecation")
		Evaluator user = new Evaluator(1L,"Piero","Rosales","rosalespiero1z3@gmail.com","75356626",new Date(111, 5,3));
		user.setCodeUser("U123123");
		user.setPassword(passwordEncoder.encode("123"));
		evaluatorRepository.save(user);
		
		@SuppressWarnings("deprecation")
		Evaluator user1 = new Evaluator(2L,"Samira","Rivera","samiraRiv@cib.edu.pe","2542326",new Date(114, 5,6));
		user.setCodeUser("U456456");
		user.setPassword(passwordEncoder.encode("345"));
		evaluatorRepository.save(user1);
	}

}
