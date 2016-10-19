package com.sample.bean;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	String name;
	String dept;
	String id;

	public Employee(String name, String dept, String id) {
		super();
		this.name = name;
		this.dept = dept;
		this.id = id;
	}

	public boolean isCheckControl() {
		return checkControl;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCheckControl(boolean checkControl) {
		this.checkControl = checkControl;
	}

	boolean checkControl = true; 

	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	String gender;
}
