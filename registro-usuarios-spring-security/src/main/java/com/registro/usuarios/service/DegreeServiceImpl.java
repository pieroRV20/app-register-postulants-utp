package com.registro.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.model.Degree;
import com.registro.usuarios.repository.IDegreeRepository;

@Service
public class DegreeServiceImpl implements IDegreeService{
	
	@Autowired
	private IDegreeRepository degreeRepository;
	
	@Override
	public List<Degree> findAll() {
		// TODO Auto-generated method stub
		return degreeRepository.findAll();
	}

}
