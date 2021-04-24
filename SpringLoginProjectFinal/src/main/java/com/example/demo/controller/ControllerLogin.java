package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.deo.UserRepository;
import com.example.demo.mod.UserLogin;

@RestController
@RequestMapping("/Customer")
public class ControllerLogin {

	@Autowired
	UserRepository userservice;

	@PostMapping("/CreateUser")
	public UserLogin SaveUserLogin(@RequestBody UserLogin userlogin) {
		System.out.println("User-created successfully");

		userservice.save(userlogin);
		return userlogin;
	}

	@PostMapping("/Login")
	public String user(@RequestParam("username") String username, @RequestParam("password") String password) {

		UserLogin auser = userservice.FindBYUserPassword(username, password);

		String Uname = auser.getUser_name();
		String Upass = auser.getPassword();

		if (username.equalsIgnoreCase(Uname) && password.equals(Upass)) {
			System.out.println("You logged In successfully ");
		} else {
			System.out.println("Wrong credentials");
		}
		return toString();

	}

	@PostMapping("/ForgetPswd")

	public UserLogin ForgetPassword(@RequestBody UserLogin userlogin) {
		System.out.println("password changed successfully");
		userservice.save(userlogin);
		return userlogin;

	}
}
//		String userName = null;
//		String password1 = null;
//
//		try {
//
//			userName = userlogin.getUser_name();
//			password1 = userlogin.getPassword();
//
//			UserLogin result = userservice.FindByUsername(userName);
//			UserLogin result1 = userservice.FindByPassword(password1);
//
//			if (result.getUser_name().equals(userName)) {
//
//				if (result1.getPassword().equals(password1)) {
//					System.out.println("You logged In successfully");
//				} else {
//					System.out.println("Wrong credentials");
//				}
//			}
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return userlogin;
//	}

//	@PostMapping("/Login1")
//	public UserLogin2 FindAllUserr(@RequestBody UserLogin2 userlogin) {
//		List<UserLogin2> result = user.FindAllUserr();
//		// List<password> UserPassword =(List<password>) userservice.findAll()
//	//	List<UserLogin2> result = user.FindAllUserr();
//		for (UserLogin2 i : result) {
//			
//			if (i.equals(result)) {
//				System.out.println("You logged In successfully");
//			} else {
//				System.out.println("Wrong credentials");
//
//			}
//		}
//		return userlogin;
//	}

//	@GetMapping("/get")
//	public List<UserLogin>FindtheUserAndPassword(@PathVariable ("name")String User_name,@PathVariable ("password")String password) {
//		return userservice.FindtheUserAndPassword();
//	}
//	
//	@GetMapping("/Getalldata")
//	public List<UserLogin> FindAllUser() {
//		return userservice.FindAllUser();
//	}
//
////	
//	@PostMapping("/ForgetPswd")
//	public UserLogin UpdateUserLogin(@RequestBody UserLogin userlogin) {
//		System.out.println("Password updated successfully");
//		return userservice.SaveUserLogin(userlogin);
//	}
//}
