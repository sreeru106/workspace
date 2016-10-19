package com.sample.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.sample.entity.EmployeeEntity;

@Component
public interface EmployeeDao {

	public String addEmployee(EmployeeEntity emp);

	public String deleteEmployee(EmployeeEntity emplist);

	public List<EmployeeEntity> fetchEmployees();

	public void updateEmployee(EmployeeEntity entity);

	public boolean checkEmp(EmployeeEntity entity);

}
