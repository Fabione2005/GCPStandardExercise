package com.standard.gcp.model.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "course")
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class Course implements Serializable {

	private static final long serialVersionUID = 3491326967246353701L;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private UUID id;
	
	@NotNull(message = "Name must not be empty")
	private String name;
	
	@NotNull(message = "Code most not be empty")
	@Size(max = 4,message = "The max size of code is 4 digits")
	@Column(unique = true)
	private String code;
	

	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;
	}
	
	public Course() 
	{
		
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
}
