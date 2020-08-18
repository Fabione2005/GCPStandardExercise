package com.standard.gcp.model.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Entity
@Table(name = "student")
@ToString
@EqualsAndHashCode
@Setter
@Getter
public class Student implements Serializable {

	private static final long serialVersionUID = 3491326967246353701L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	@NotNull(message = "Rut most not be empty")
	@Column(unique = true)
	private String rut;

	@NotNull(message = "Name most not be empty")
	private String name;

	@NotNull(message = "Lastname most not be empty")
	private String lastName;

	@NotNull(message = "Age most not be empty")
	@Min(value = 18, message = "Minimun age for registration is 18")
	private int age;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "course_id")
	private Course course;

	public Student(String rut, String name, String lastName, int age, Course course) {
		super();
		this.rut = rut;
		this.name = name;
		this.lastName = lastName;
		this.age = age;
		this.course = course;
	}
	
	public Student() 
	{
		
	}
	
	public UUID getId() {
		return id;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
