package com.registro.usuarios.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.registro.usuarios.model.Degree;

public interface IDegreeRepository extends JpaRepository<Degree, Integer> {
	
}
