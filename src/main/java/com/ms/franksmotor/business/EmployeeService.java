package com.ms.franksmotor.business;

import com.ms.franksmotor.model.request.EmployeeRequest;
import com.ms.franksmotor.model.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

	List<EmployeeResponse> findAll();
	
	EmployeeResponse findById (int id);
	
	EmployeeResponse createEmployee (EmployeeRequest request);
	
}
