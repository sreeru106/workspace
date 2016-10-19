package com.sample.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sample.entity.EmployeeEntity;
import com.sample.entity.UserEntity;
import com.sample.repository.EmployeeRepository;
import com.sample.repository.UserRepository;

@Component
@Transactional(propagation = Propagation.REQUIRED)
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	EmployeeRepository emprepo;
	@Autowired
	UserRepository userRepo;

	public String addEmployee(EmployeeEntity emp) {
		try {
			UserEntity user = new UserEntity();
			user.setUserAge("20");
			user.setUserId(123);
			user.setUserName("namerrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrrr");

			emprepo.save(emp);
			// userRepo.saveAndFlush(user);
		} catch (DataAccessException E) {
			return "fail";
		}
		return "success";

	}

	public String deleteEmployee(EmployeeEntity emplist) {

		try {
			emprepo.delete(emplist);
		} catch (DataAccessException E) {
			return "fail";
		}
		return "success";
	}

	@Override
	public List<EmployeeEntity> fetchEmployees() {
		List<EmployeeEntity> emplist;
		emplist = emprepo.findAll();
		return emplist;

	}

	@Override
	public void updateEmployee(EmployeeEntity entity) {

		emprepo.updateEmpData(entity.getEmpName(), entity.getEmpDep(),
				entity.getEmpId());
	}

	@Override
	public boolean checkEmp(EmployeeEntity entity) {
		if (emprepo.findOne(entity.getEmpId()) != null) {
			return true;
		} else {
			return false;
		}

	}

}
