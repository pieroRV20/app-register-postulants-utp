package com.registro.usuarios.service;

import java.util.List;

import com.registro.usuarios.model.Evaluator;
import com.registro.usuarios.model.Postulant;
import com.registro.usuarios.model.Register;

public interface IRegisterService {

	public List<Register> findAll();
	
	public Register findOne(Long registerId);
	
	public List<Register> findMyRegisters(Evaluator evaluator);
	
	public void save(Register register);

	public void saveIntern(Postulant postulant, String userCode);

	public void saveExtern(Postulant postulant, Integer idOrigin);


	public void delete(Long registerId);
	
	public void assignRegister(String code, Register register);

}
