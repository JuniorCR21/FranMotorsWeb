package com.ms.franksmotor.scheduler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.ms.franksmotor.model.db.User;
import com.ms.franksmotor.repository.UserRepository;

@Component
public class SchedulerUnlockedUser {

	@Autowired
	private UserRepository userRepository;
	
	@Scheduled(cron = "0 0/15 * * * *", zone = "America/Lima")
	public void unlockedUser() {
		List<User> users = userRepository.findBySession();
		if (!users.isEmpty()) {
			users.forEach(u -> userRepository.updateUnlockedUser(u.getId()));
		}
	}
}
