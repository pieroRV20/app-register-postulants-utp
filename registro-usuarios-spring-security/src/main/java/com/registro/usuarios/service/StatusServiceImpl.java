package com.registro.usuarios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.registro.usuarios.model.Status;
import com.registro.usuarios.repository.IStatusRepository;

@Service
public class StatusServiceImpl implements IStatusService {
	
	@Autowired
	private IStatusRepository statusRepository;
	
	@Override
	public List<Status> findAll() {
		// TODO Auto-generated method stub
		return statusRepository.findAll();
	}

	@Override
	public Status findById(Integer id) {
		// TODO Auto-generated method stub
		return statusRepository.findById(id).orElse(null);
	}

}
