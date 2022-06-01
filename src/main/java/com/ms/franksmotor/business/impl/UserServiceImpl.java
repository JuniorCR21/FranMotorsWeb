package com.ms.franksmotor.business.impl;

import com.ms.franksmotor.business.UserService;
import com.ms.franksmotor.model.db.Employee;
import com.ms.franksmotor.model.db.User;
import com.ms.franksmotor.model.request.UserRequest;
import com.ms.franksmotor.model.response.EmployeeResponse;
import com.ms.franksmotor.repository.EmployeeRepository;
import com.ms.franksmotor.repository.UserRepository;
import com.ms.franksmotor.utils.Utils;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Optional<EmployeeResponse> findByUsernameAndPassword(String username, String password) {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			if (userRepository.findByUsernameAndPassword(username, password) != null &&
					user.getAccountLocked() < 3) {
				LOGGER.debug("Usuario {} encontrado", username);
				Employee employee = employeeRepository.findByUserId(user.getId());
				return Optional.of(new EmployeeResponse(employee.getId(), user.getId(),
						employee.getName(), employee.getSurname(), 
						employee.getDni(), employee.getEmail(), 
						employee.getPhone(), employee.getDateBirth(), 
						username, user.getStatus(), user.getRole(), false));
			} else {
				LOGGER.debug("Usuario {} no corresponde contraseña", username);
				EmployeeResponse response = new EmployeeResponse();
				if (user.getAccountLocked() < 3) {
					userRepository.updateAccountLocked(user.getAccountLocked()+1, user.getId());
					response.setUsername(user.getUsername());
					response.setStatus(false);
				} else {
					LOGGER.debug("Usuario {} bloqueado", username);
					response.setUsername(user.getUsername());
					response.setAccountLocked(true);
				}
				return Optional.of(response);
			}
		}
		LOGGER.debug("Usuario {} no encontrado: {}", username, user);
		return Optional.empty();
	}

	@Transactional
	@Override
	public Optional<User> createUser(String username, String password, String role) {
		if (Utils.validPassword(password)) {
			User user = new User();
			user.setUsername(username);
			user.setAccountLocked(0);
			user.setPassword(password);
			user.setRole(role);
			user.setStatus(Boolean.TRUE);
			return Optional.of(userRepository.save(user));
		}
		return Optional.empty();
	}

	@Override
	public Boolean updateStatusById(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.updateStatus(!user.get().getStatus(), id);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean updatePasswordById(UserRequest request) {
		if (Utils.validPassword(request.getPassword())) {
			LOGGER.debug("Contraseña Valida");
			Optional<User> user = userRepository.findById(request.getId());
			if (user.isPresent()) {
				LOGGER.debug("Usuario encontrado");
				userRepository.updatePassword(request.getPassword(), request.getId());
				return Boolean.TRUE;
			}
			return Boolean.FALSE;
		}
		return Boolean.FALSE;
	}

	@Override
	public Boolean updateUnlockedUser(int id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			userRepository.updateUnlockedUser(id);
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}

}
