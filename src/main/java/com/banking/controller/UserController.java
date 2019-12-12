package com.banking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.banking.dto.UserDto;
import com.banking.service.UserService;

@RestController
public class UserController {

	@Autowired
	UserService userService;
	
	@PostMapping("/saveuser")
	public UserDto  saveUserDetails(@RequestBody UserDto userDto) {
		UserDto userDto1 = userService.saveUser(userDto);
		
		return userDto1;
		
	}
	
	
}
