package com.praveen.financialtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.praveen.financialtracker.model.UserModel;
import com.praveen.financialtracker.service.UserService;

@RestController
@RequestMapping("/financial")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/userdetails")
	public ResponseEntity<List<UserModel>> getAllUsersDetails() {
		return ResponseEntity.ok().body(userService.fetchUsers());
	}

	@GetMapping(value = "/userdetails/{userId}")
	public ResponseEntity<UserModel> getUsersDetails(@PathVariable Long userId) {
		return ResponseEntity.ok().body(userService.fetchUserById(userId));
	}

	@PostMapping(value = "/save/user")
	public ResponseEntity<UserModel> saveUser(@RequestBody UserModel userModel) {
		return ResponseEntity.ok().body(userService.saveUser(userModel));
	}

	@PutMapping(value = "/update/user")
	public ResponseEntity<UserModel> updateUser(@RequestBody UserModel userModel) {
		return ResponseEntity.ok().body(userService.updateUser(userModel));
	}

	@DeleteMapping(value = "/delete/user/{userId}")
	public ResponseEntity<UserModel> deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
		return ResponseEntity.ok().build();
	}

}
