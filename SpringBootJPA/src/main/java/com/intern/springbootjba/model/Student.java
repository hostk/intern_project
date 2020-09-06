package com.intern.springbootjba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String rollNo;
	private int age;
	private String phoneNo;
	public int getAge() {
		return age;
	}
	public Student(Long id, String name, String rollNo, int age, String phoneNo) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.age = age;
		this.phoneNo = phoneNo;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public Student(Long id, String name, String rollNo) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
	}
	public Student() {
		super();
	}
	public Student(String name, String rollNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
	}
	
	
}
