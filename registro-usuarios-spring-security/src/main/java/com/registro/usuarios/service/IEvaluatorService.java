package com.registro.usuarios.service;

import java.util.List;

import com.registro.usuarios.model.Evaluator;

public interface IEvaluatorService {
	public Evaluator findByCode(String codeUser);
	public List<Evaluator>  findAll();
}
