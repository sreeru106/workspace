package com.sample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sample.bean.Employee;
import com.sample.bean.Employees;
import com.sample.dao.EmployeeDao;
import com.sample.entity.EmployeeEntity;

@Component
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeDao empdao;

	public void addEmployee(Employee employee) {
		System.out.println("inside service");
		EmployeeEntity entity = new EmployeeEntity();
		mapBeanToEntity(employee, entity);
		if (checkEmp(entity)) {

			empdao.updateEmployee(entity);
		} else {
			empdao.addEmployee(entity);
		}

	}

	private boolean checkEmp(EmployeeEntity entity) {

		return empdao.checkEmp(entity);
	}

	public String deleteEmployee(Employee employee) {

		EmployeeEntity entity = new EmployeeEntity();
		mapBeanToEntity(employee, entity);
		return empdao.deleteEmployee(entity);
	}

	private void mapBeanToEntity(Employee employee, EmployeeEntity entity) {
		System.out.println(employee.getDept());
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		entity.setEmpDep(employee.getDept());
		entity.setEmpId(Integer.parseInt(employee.getId()));
		entity.setEmpName(employee.getName());

	}

	@Override
	public List<Employee> fetchEmployee() {
		List<Employee> employess = new ArrayList<Employee>();
		List<EmployeeEntity> emplist = empdao.fetchEmployees();
		for (EmployeeEntity emp : emplist) {
			Employee employee = new Employee();
			mapEntityToBean(employee, emp);
			employess.add(employee);
		}
		return employess;
	}

	private void mapEntityToBean(Employee employee, EmployeeEntity emp) {
		employee.setDept(emp.getEmpDep());
		employee.setId(String.valueOf(emp.getEmpId()));
		employee.setName(emp.getEmpName());

	}

}
