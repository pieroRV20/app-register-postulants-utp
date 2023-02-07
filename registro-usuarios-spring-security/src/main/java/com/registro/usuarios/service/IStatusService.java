package com.registro.usuarios.service;

import java.util.List;

import com.registro.usuarios.model.Status;

public interface IStatusService {
	public List<Status> findAll();
	public Status findById(Integer id);
}
