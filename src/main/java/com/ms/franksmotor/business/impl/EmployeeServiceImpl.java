package com.ms.franksmotor.business.impl;

import com.ms.franksmotor.business.EmployeeService;
import com.ms.franksmotor.business.UserService;
import com.ms.franksmotor.model.db.Employee;
import com.ms.franksmotor.model.db.User;
import com.ms.franksmotor.model.request.EmployeeRequest;
import com.ms.franksmotor.model.response.EmployeeResponse;
import com.ms.franksmotor.repository.EmployeeRepository;
import com.ms.franksmotor.utils.Utils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private UserService userService;
	
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
	    Optional<User> user = userService.createUser(Utils.createUsername(request.getName(), 
	            request.getSurname()), request.getPassword(), request.getRole());
	    if (user.isPresent()) {
	        Employee employee = new Employee();
	        employee.setUser(user.get());
	        employee.setName(request.getName());
	        employee.setSurname(request.getSurname());
	        employee.setDni(request.getDni());
	        employee.setDateBirth(request.getDateBirth());
	        employee.setEmail(request.getEmail());
	        employee.setPhone(request.getPhone());
	        employee = employeeRepository.save(employee);
	        return new EmployeeResponse(employee.getId(),employee.getUser().getId(),
	                employee.getName(), employee.getSurname(), employee.getDni(),
	                employee.getEmail(), employee.getPhone(), employee.getDateBirth(),
	                employee.getUser().getUsername(), employee.getUser().getStatus(),
	                employee.getUser().getRole(), employee.getUser().getAccountLocked() >= 3);
	    }
		return null;
	}

}
