package com.idu.judi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idu.judi.exception.UserNotFound;
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
	@Transactional(rollbackFor = UserNotFound.class)
	public boolean update(User user) throws UserNotFound {
		User updateUser = userRepository.findOne(user.getUserId());
		if (updateUser == null)
			throw new UserNotFound();
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
	@Transactional(rollbackFor = UserNotFound.class)
	public boolean delete(int userId) throws UserNotFound {
		User deleteUser = userRepository.findOne(userId);
		if (deleteUser == null)
			throw new UserNotFound();
		userRepository.delete(deleteUser);
		return true;
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