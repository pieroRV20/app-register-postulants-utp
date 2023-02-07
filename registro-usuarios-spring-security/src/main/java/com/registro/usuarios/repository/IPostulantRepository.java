package com.registro.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.model.Postulant;

public interface IPostulantRepository extends JpaRepository<Postulant, Long> {
	
}
