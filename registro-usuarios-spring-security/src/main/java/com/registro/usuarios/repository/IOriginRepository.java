package com.registro.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.registro.usuarios.model.TypeOrigin;

@Repository
public interface IOriginRepository extends JpaRepository<TypeOrigin, Integer> {

}
