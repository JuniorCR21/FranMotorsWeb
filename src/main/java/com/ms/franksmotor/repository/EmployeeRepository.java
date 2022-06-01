package com.ms.franksmotor.repository;

import com.ms.franksmotor.model.db.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(value = "select * from employee e where e.user_id = :user limit 1", nativeQuery = true)
	Employee findByUserId (@Param("user") int userId);
}
