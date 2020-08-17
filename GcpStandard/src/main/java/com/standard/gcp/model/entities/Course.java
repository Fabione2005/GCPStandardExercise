package com.standard.gcp.model.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@Size(max = 4)
	private String code;
	
	@OneToOne(mappedBy = "course")
    @JsonIgnore
	private Student student;

	public Course(String name, String code) {
		super();
		this.name = name;
		this.code = code;
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
