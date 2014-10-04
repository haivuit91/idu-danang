package com.idu.judi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idu.judi.model.User;
import com.idu.judi.repository.UserRepository;
import com.idu.judi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserRepository userRepository;

	@Override
	@Transactional
	public boolean create(User user) {
		userRepository.save(user);
		return true;
	}

	@Override
	@Transactional
	public boolean update(User user) {
		User updateUser = userRepository.findOne(user.getUserId());
		if (updateUser == null) {
			return false;
		}
		updateUser.setUserName(user.getUserName());
		updateUser.setFullName(user.getFullName());
		updateUser.setBirthOfDay(user.getBirthOfDay());
		updateUser.setGender(user.getGender());
		updateUser.setIdCard(user.getIdCard());
		updateUser.setAddress(user.getAddress());
		updateUser.setEmail(user.getEmail());
		updateUser.setPhoneNumber(user.getPhoneNumber());
		updateUser.setRole(user.getRole());
		userRepository.save(updateUser);
		return true;
	}

	@Override
	@Transactional
	public boolean delete(int userId) {
		User deleteUser = userRepository.findOne(userId);
		try {
			userRepository.delete(deleteUser);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	@Transactional
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	@Transactional
	public User findById(int userId) {
		return userRepository.findOne(userId);
	}

	@Override
	@Transactional
	public User findByRole(int role) {
		return userRepository.findOne(role);
	}

}