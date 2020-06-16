package com.example.demo.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDto;
import com.example.demo.request.UserDetails;
import com.example.demo.response.UserRestResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("users") //http://localhost:8080/users
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public String getuser()
	{
		return "we got the user";
	}
	
	@PostMapping
	public UserRestResponse createUser(@RequestBody UserDetails userDetails)
	{
        UserRestResponse reponse = new UserRestResponse();
		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails,userDto);
		
		UserDto createUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createUser, reponse);
		return reponse;
	}
	
	@PutMapping
	public String updateUser()
	{
		return "user has updated";
	}
	
	@DeleteMapping
	public String deleteUser()
	{
		return "user deleted";
	}
	
	
}
