package com.ms.franksmotor.controllers;

import com.ms.franksmotor.business.UserService;
import com.ms.franksmotor.model.request.UserRequest;
import com.ms.franksmotor.model.response.EmployeeResponse;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/franksmotor/v1/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	private static final String ERROR_UPDATE = "ERROR UPDATE PASSWORD";

	@Autowired
	private UserService userService;
	
	@PostMapping("/login")
	@ResponseBody
	public ResponseEntity<EmployeeResponse> findUserByUsernameAndPassword (
			@RequestBody UserRequest request){
		Optional<EmployeeResponse> response = userService.findByUsernameAndPassword(request.getUsername(), request.getPassword());
		if (!response.isEmpty()) {
			return ResponseEntity.ok(response.get());
		}
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/")
	public ResponseEntity<String> updatePasswordByUserId (
			@RequestBody UserRequest request){
		boolean response = userService.updatePasswordById(request);
		if (response) {
			return new ResponseEntity<>("OK", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(ERROR_UPDATE, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/unlocked/{id}")
	public ResponseEntity<String> unlockedUserByUserId (
			@PathVariable("id") int idUser){
		boolean response = userService.updateUnlockedUser(idUser);
		if (response) {
			return new ResponseEntity<>("OK", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(ERROR_UPDATE, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/status/{id}")
	public ResponseEntity<String> updateUserStatusByUserId (
			@PathVariable("id") int idUser){
		boolean response = userService.updateStatusById(idUser);
		if (response) {
			return new ResponseEntity<>("OK", HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<>(ERROR_UPDATE, HttpStatus.BAD_REQUEST);
	}
}
