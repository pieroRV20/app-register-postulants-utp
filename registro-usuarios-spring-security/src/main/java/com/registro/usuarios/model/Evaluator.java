package com.registro.usuarios.model;


import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "evaluators")
public class Evaluator extends Person {

	@Column(name="code_user")
	private String code;
	
	private String password;

	@OneToMany(mappedBy="evaluator")
	private List<Register> listRecords;
	
	public Evaluator(Long id, @NotBlank @NotNull String name, @NotBlank @NotNull String lastName,
			@Email @NotBlank String email, @NotBlank String dni, @NotNull Date birthday) {
		super(id, name, lastName, email, dni, birthday);
		// TODO Auto-generated constructor stub
	}

	public Evaluator(String code, String password, List<Register> listRecords) {
		super();
		this.code = code;
		this.password = password;
		this.listRecords = listRecords;
	}

	public Evaluator() {
		super();
	}


	public String getCode() {
		return code;
	}
	public void setCodeUser(String code) {
		this.code = code;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Register> getListRecords() {
		return listRecords;
	}
	public void setListRecords(List<Register> listRecords) {
		this.listRecords = listRecords;
	}

}
