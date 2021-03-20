package com.cnc.Controller;
import com.cnc.Model.UserModel;
import com.cnc.Service.UserService;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/users")
public class User {
	
	@Autowired
	private UserService userservices;
	
	
	
	@GetMapping("/showusers")
	public List<UserModel> allusers() {
		return userservices.findAllUsers();
	}
	
	@PostMapping("/adduser")
	
	public String addUser( @RequestBody UserModel userData) {
		return userservices.SaveUser(userData);
		
		
	}
	
	@PutMapping("/updateuser")
	
	public String updateUser(@RequestBody UserModel newUserData) {
		return userservices.UpdateUser(newUserData);
		
	}
	
	@GetMapping("/finduser/{user_id}")
	
	public Optional<UserModel> findUserById(@PathVariable Integer user_id) {
		
		return userservices.findUserById(user_id);
		
	}
	
	/*@GetMapping("/finduserbytp/{telephone}")
		public UserModel findUserByTp(@PathVariable String telephone) {
		return userservices.findUserByTelephone(telephone);
	}*/
	
	@GetMapping("findusers/{username}/{password}")
	public boolean findUserByCreditials(@PathVariable String username,@PathVariable String password) {
		if(userservices.findUserByCreditials(username,password)) {
			return true;
		}
		else
			return false;
		
	}
}