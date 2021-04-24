package com.example.demo.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.User_pojo.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	
	//@Query(" ")
	//public List<User> FindByEmail(String email);
	
	
	@Query("from User where user_name=?1 and user_password=?2")
	public User FindBYUserPassword(String username,String password);

}
