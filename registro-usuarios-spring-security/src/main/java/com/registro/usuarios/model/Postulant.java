package com.registro.usuarios.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="postulants")
public class Postulant extends Person{
	
	@Column(name="name_school")
	@NotNull
	@NotBlank
	private String nameSchool;
	
	@NotNull
	@OneToOne
	private Degree degree;
	
	@NotBlank
	@NotNull
	private String observation;
	

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getNameSchool() {
		return nameSchool;
	}

	public void setNameSchool(String nameSchool) {
		this.nameSchool = nameSchool;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}
	
}
