package com.registro.usuarios.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.registro.usuarios.model.Evaluator;
import com.registro.usuarios.model.Postulant;
import com.registro.usuarios.model.Register;
import com.registro.usuarios.repository.IEvaluatorRepository;
import com.registro.usuarios.repository.IOriginRepository;
import com.registro.usuarios.repository.IPostulantRepository;
import com.registro.usuarios.repository.IRegisterRepository;
import com.registro.usuarios.repository.IStatusRepository;


@Service
public class RegisterServiceImpl implements IRegisterService{
		
	@Autowired
	private IRegisterRepository registerRepository;
	
	@Autowired
	private IPostulantRepository postulantRepository;
	
	@Autowired
	private IOriginRepository originRepository;
	
	@Autowired
	private IStatusRepository statusRepository;
	
	@Autowired
	private IEvaluatorRepository evaluatorRepository;

	@Override
	@Transactional(readOnly=true)
	public List<Register> findAll() {
		return registerRepository.findAll();
	}

	@Override
	@Transactional
	public void saveIntern(Postulant postulant, String userCode) {
		//Insertando postulante a la base de datos
		postulantRepository.save(postulant);
		
		//Obteniendo datos del evaluador
		Evaluator evaluator = evaluatorRepository.findByCode(userCode);
		

		Register register = new Register();
		
		register.setEvaluator(evaluator);
		
		if (originRepository.findById(1).isPresent()) {
			register.setOrigin(originRepository.findById(1).get());
		}
		
		if (statusRepository.findById(1).isPresent()) {
			register.setStatus(statusRepository.findById(1).get());
		}
		
		register.setPostulant(postulant);
		register.setSendDay(new Date());
		
		registerRepository.save(register);
	}

	@Override
	public void saveExtern(Postulant postulant, Integer idOrigin) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional(readOnly=true)
	public Register findOne(Long registerId) {
		return registerRepository.findById(registerId).orElse(null);
	}
	
	@Override
	@Transactional
	public void delete(Long registerId) {
		registerRepository.deleteById(registerId); 
	}

	@Override
	@Transactional
	public void assignRegister(String code,Register register) {
		// TODO Auto-generated method stub
		Evaluator evaluator = evaluatorRepository.findByCode(code);
		register.setEvaluator(evaluator);
		registerRepository.save(register);

	}

	@Override
	@Transactional
	public void save(Register register) {
		// TODO Auto-generated method stub
		registerRepository.save(register);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Register> findMyRegisters(Evaluator evaluator) {
		// TODO Auto-generated method stub
		return registerRepository.findByEvaluator(evaluator);
	}
}
