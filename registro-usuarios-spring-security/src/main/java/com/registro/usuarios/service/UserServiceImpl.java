package com.registro.usuarios.service;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.registro.usuarios.model.Evaluator;
import com.registro.usuarios.repository.IEvaluatorRepository;


@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	private IEvaluatorRepository evaluatorRepository;
	
	private static final List<String> ROLES = Arrays.asList("EVALUATOR");
	
	@Override
	public UserDetails loadUserByUsername(String code) throws UsernameNotFoundException {
		Evaluator evaluator = evaluatorRepository.findByCode(code);
		
		if (evaluator==null) {
			throw new UsernameNotFoundException("User not found"+code);	
		}

		return new User(evaluator.getCode(),evaluator.getPassword(),mappingAuthorities()); 
	}
	
	public Collection<? extends GrantedAuthority> mappingAuthorities() {
		return ROLES.stream().map(role -> new SimpleGrantedAuthority("EVALUATOR")).collect(Collectors.toList());
	}

}
