package com.registro.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.model.Status;

public interface IStatusRepository extends JpaRepository<Status, Integer> {
	
}
