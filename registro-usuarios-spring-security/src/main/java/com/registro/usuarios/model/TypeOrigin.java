package com.registro.usuarios.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="types_origin")
public class TypeOrigin {
	
	@Id
	private Integer id;
	
	private String name;
	

	public TypeOrigin() {

	}

	public TypeOrigin(Integer id, String name) {
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
