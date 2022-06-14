package com.bridgelabz.userregistration.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.userregistration.dto.UserDTO;
import com.bridgelabz.userregistration.model.UserData;
import com.bridgelabz.userregistration.service.UserServiceI;
import com.bridgelabz.userregistration.utility.TokenUtil;

@RequestMapping("/userregistration")
@RestController
public class UserController {

	@Autowired
	UserServiceI userServiceI;

	@Autowired
	TokenUtil tokenUtil ;

	@GetMapping("/getUserInfo")
	public List<UserData> getUserInfo() {
		List<UserData> userDataList = null;
		userDataList = userServiceI.getUserInfo();
		return userDataList;
	}

	@RequestMapping("/addUserInfo")
	public String addUserInfo(@Valid @RequestBody UserDTO userDTO) {
		userServiceI.addUser(userDTO);
		return "Saved Data";
	}

	@PostMapping("/createtoken")
	public String createtoken(@RequestBody String userId) {
		String token = tokenUtil.createToken(userId);
		return token;
	}
	
	@PostMapping("/decodeToken")
	public String decodeToken(@RequestBody String token) {
		String userId = tokenUtil.decodeToken(token);
		return userId;
	}
}
