package com.idu.judi.service;

import java.util.List;

import com.idu.judi.model.User;

public interface UserService {

	/**
	 * Creates a new user.
	 * 
	 * @param created
	 *            The information of the created user.
	 * @return The created user.
	 */
	public boolean create(User user);

	/**
	 * Updates the information of a user.
	 * 
	 * @param updated
	 *            The information of the updated user.
	 * @return The updated user.
	 */
	public boolean update(User user);

	/**
	 * Deletes a user.
	 * 
	 * @param userId
	 *            The id of the deleted user.
	 * @return The deleted user.
	 */
	public boolean delete(int userId);

	/**
	 * Finds all user.
	 * 
	 * @return A list of user.
	 */
	public List<User> findAll();

	/**
	 * Finds user by userID.
	 * 
	 * @param id
	 *            The id of the wanted user.
	 * @return The found user. If no user is found, this method returns null.
	 */
	public User findById(int userId);
	
	/**
	 * Finds user by role.
	 * 
	 * @param id
	 *            The id of the wanted user.
	 * @return The found user. If no user is found, this method returns null.
	 */
	public User findByRole(int role);

}
