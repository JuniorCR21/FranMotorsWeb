package com.ms.franksmotor.business.impl;

import com.ms.franksmotor.business.EmployeeService;
import com.ms.franksmotor.model.db.Employee;
import com.ms.franksmotor.model.request.EmployeeRequest;
import com.ms.franksmotor.model.response.EmployeeResponse;
import com.ms.franksmotor.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<EmployeeResponse> findAll() {
		List<Employee> employees = employeeRepository.findAll();
		if (!employees.isEmpty()) {
			List<EmployeeResponse> response = new ArrayList<>();
			for (Employee employee : employees) {
				response.add(new EmployeeResponse(employee.getId(),employee.getUser().getId(), 
						employee.getName(), employee.getSurname(), 
						employee.getDni(), employee.getEmail(), 
						employee.getPhone(), employee.getDateBirth(), 
						employee.getUser().getUsername(), employee.getUser().getStatus(), 
						employee.getUser().getRole(), employee.getUser().getAccountLocked() >=3));
			}
			return response;
		}
		return Collections.emptyList();
	}

	@Override
	public EmployeeResponse findById(int id) {
		return null;
	}

	@Override
	public EmployeeResponse createEmployee(EmployeeRequest request) {
		return null;
	}

}
