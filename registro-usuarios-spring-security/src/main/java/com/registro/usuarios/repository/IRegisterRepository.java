package com.registro.usuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.model.Evaluator;
import com.registro.usuarios.model.Register;

@Repository
public interface IRegisterRepository extends JpaRepository<Register, Long>{
	
	List<Register> findByEvaluator(Evaluator evaluator);
}
