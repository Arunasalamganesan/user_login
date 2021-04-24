package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.Repo.UserRepository;
import com.example.demo.User_pojo.User;

@Controller
public class UserController {
	
	@Autowired
	UserRepository urepo;
	
	@PostMapping("adduser")
	public User adduser(@RequestBody User user)
	{
		urepo.save(user);
		System.out.println("its done");
		return user;
		
	}
	
	@PostMapping("/Login")
	public String LoginUser(@RequestParam("username") String username,@RequestParam("password") String password) {
		
		User auser=urepo.FindBYUserPassword(username, password);
		
		String Uname=auser.getUser_name();
		String Upass=auser.getUser_password();
		
		if(username.equalsIgnoreCase(Uname) && password.equals(Upass)) {
			System.out.println("You logged In successfully ");
		}
		 else {
				System.out.println("Wrong credentials");
			}
		return toString();
		
	}
	

}
