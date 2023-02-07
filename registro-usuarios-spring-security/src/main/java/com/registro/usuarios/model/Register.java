package com.registro.usuarios.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;



@Entity
@Table(name="registers")
public class Register {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@OneToOne
	private Postulant postulant;
	
	@OneToOne
	@NotNull
	private Status status;
	
	@OneToOne
	@NotNull
	private TypeOrigin origin;
	
	@ManyToOne
	@JoinColumn(nullable = true)
	private Evaluator evaluator;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	@NotNull
	private Date sendDay;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Postulant getPostulant() {
		return postulant;
	}

	public void setPostulant(Postulant postulant) {
		this.postulant = postulant;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public TypeOrigin getOrigin() {
		return origin;
	}

	public void setOrigin(TypeOrigin origin) {
		this.origin = origin;
	}

	public Evaluator getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(Evaluator evaluator) {
		this.evaluator = evaluator;
	}

	public Date getSendDay() {
		return sendDay;
	}

	public void setSendDay(Date sendDay) {
		this.sendDay = sendDay;
	}

	
}