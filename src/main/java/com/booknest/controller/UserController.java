package com.booknest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booknest.dto.UserDTO;
import com.booknest.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping
	public ResponseEntity<UserDTO> registerUser(@RequestBody @Valid UserDTO userDTO) {
		UserDTO registeredUser = userService.registerUser(userDTO);
		return ResponseEntity.ok(registeredUser);
	}

	@GetMapping("/profile/{userId}")
	public ResponseEntity<UserDTO> getUserProfile(@PathVariable Long userId) {
		UserDTO user = userService.getUserProfile(userId);
		return ResponseEntity.ok(user);
	}

	@PutMapping("/profile/{userId}")
	public ResponseEntity<UserDTO> updateUserProfile(@PathVariable Long userId, @RequestBody @Valid UserDTO userDTO) {
		UserDTO updatedUser = userService.updateUserProfile(userId, userDTO);
		return ResponseEntity.ok(updatedUser);
	}
}
