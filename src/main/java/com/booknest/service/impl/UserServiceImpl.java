package com.booknest.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booknest.dto.UserDTO;
import com.booknest.entity.User;
import com.booknest.exception.NotFoundException;
import com.booknest.repo.UserRepository;
import com.booknest.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDTO registerUser(UserDTO userDTO) {
		User user = modelMapper.map(userDTO, User.class);
		User savedUser = userRepository.save(user);
		return modelMapper.map(savedUser, UserDTO.class);
	}

	@Override
	public UserDTO getUserProfile(Long userId) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
		return modelMapper.map(user, UserDTO.class);
	}

	@Override
	public UserDTO updateUserProfile(Long userId, UserDTO userDTO) {
		User user = userRepository.findById(userId).orElseThrow(() -> new NotFoundException("User not found"));
		user.setUsername(userDTO.getUsername());
		user.setEmail(userDTO.getEmail());
		user.setFirstName(userDTO.getFirstName());
		user.setLastName(userDTO.getLastName());
		user.setPassword(userDTO.getPassword()); // Ideally, you'd encrypt the password here
		User updatedUser = userRepository.save(user);
		return modelMapper.map(updatedUser, UserDTO.class);
	}
}
