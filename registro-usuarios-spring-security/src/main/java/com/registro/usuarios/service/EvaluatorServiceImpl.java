package com.registro.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.model.Evaluator;
import com.registro.usuarios.repository.IEvaluatorRepository;

@Service
public class EvaluatorServiceImpl implements IEvaluatorService {
	
	@Autowired
	private IEvaluatorRepository evaluatorRepository;
	
	@Override
	public Evaluator findByCode(String codeUser) {
		// TODO Auto-generated method stub
		return evaluatorRepository.findByCode(codeUser) ;
	}

	@Override
	public List<Evaluator> findAll() {
		// TODO Auto-generated method stub
		return evaluatorRepository.findAll();
	}

}
