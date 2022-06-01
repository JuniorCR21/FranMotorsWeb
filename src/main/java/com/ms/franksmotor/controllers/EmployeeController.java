package com.ms.franksmotor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.franksmotor.business.EmployeeService;
import com.ms.franksmotor.model.response.EmployeeResponse;

@RestController
@RequestMapping("/franksmotor/v1/employee")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	@ResponseBody
	public ResponseEntity<List<EmployeeResponse>> listEmployee() {
		List<EmployeeResponse> response = employeeService.findAll();
		if (!response.isEmpty()) {
			return ResponseEntity.ok(response);
		}
		return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
	}
}
