package com.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sample.entity.EmployeeEntity;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

	@Modifying
	@Query("update EmployeeEntity u set u.empName = ?1, u.empDep = ?2 where u.empId = ?3")
	void updateEmpData(String name, String dept, Long id);

}
