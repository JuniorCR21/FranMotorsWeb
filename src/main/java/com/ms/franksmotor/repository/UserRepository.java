package com.ms.franksmotor.repository;

import com.ms.franksmotor.model.db.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "SELECT * FROM user u WHERE u.username = :username and u.password = :password and u.status = true", 
			nativeQuery = true)
	User findByUsernameAndPassword (
			@Param("username") String username, 
			@Param("password") String password);
	
	User findByUsername (String username);
	
	@Query(value = "SELECT * FROM user u WHERE (u.session_at BETWEEN DATE_SUB(NOW(), INTERVAL 1 HOUR) AND NOW()) AND (u.account_locked >= 3)", 
			nativeQuery = true)
	List<User> findBySession();
	
	@Transactional
	@Modifying
	@Query("update User u set u.accountLocked = 0 where u.id = :id")
	int updateUnlockedUser(@Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("update User u set u.accountLocked = :number where u.id = :id")
	int updateAccountLocked(@Param("number") int number, @Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("update User u set u.status = :status where u.id = :id")
	int updateStatus(@Param("status") boolean status, @Param("id") int id);
	
	@Transactional
	@Modifying
	@Query("update User u set u.password = :password, u.accountLocked = 0 where u.id = :id")
	int updatePassword(@Param("password") String password, @Param("id") int id);
}
