package com.sample.controller;

import java.util.List;

import javax.print.attribute.standard.Media;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.bean.Employee;
import com.sample.service.EmployeeService;

@RestController
@RequestMapping(value = "/authUser")
public class EmpRegistrationController {

	@Autowired
	private EmployeeService empserice;

	@RequestMapping(value = "/registration.html", method = RequestMethod.GET)
	public String getRegForm() {

		return "EmployeeRegistration";
	}

	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	public List<Employee> addUSer(Employee employee,HttpServletRequest request) {

		if(employee.getDept()!=null && employee.getId()!=null&&employee.getName()!=null){
			empserice.addEmployee(employee);	
		}

		List<Employee> employess = empserice.fetchEmployee();
		// ServletContextListener implementaion
		ServletContext sc = request.getServletContext();
		System.out.println("Path:" + sc.getAttribute("filePath"));
		System.out.println("Mode:" + sc.getAttribute("fileMode"));
		return employess;
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST )
	public List<Employee> deleteEmp(Employee employee) {

		if(employee.getDept()!=null && employee.getId()!=null&&employee.getName()!=null){
			empserice.deleteEmployee(employee);
		}
		System.out.println("employee==" +employee);
		List<Employee> employess = empserice.fetchEmployee();
		return employess;
	}
}
