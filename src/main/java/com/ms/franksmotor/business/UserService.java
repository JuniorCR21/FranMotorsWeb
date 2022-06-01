package com.ms.franksmotor.business;

import com.ms.franksmotor.model.db.User;
import com.ms.franksmotor.model.request.UserRequest;
import com.ms.franksmotor.model.response.EmployeeResponse;
import java.util.Optional;

public interface UserService{

	Optional<EmployeeResponse> findByUsernameAndPassword (String username, String password);
	
	Optional<User> createUser (String username, String password, String role);
	
	Boolean updateStatusById (int id);
	
	Boolean updatePasswordById (UserRequest request);
	
	Boolean updateUnlockedUser (int id);
	
}
