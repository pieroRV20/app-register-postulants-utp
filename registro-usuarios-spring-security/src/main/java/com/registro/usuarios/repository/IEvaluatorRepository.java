package com.registro.usuarios.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.model.Evaluator;

public interface IEvaluatorRepository extends JpaRepository<Evaluator, Long>{

	Evaluator findByCode(String codeUser);
}
