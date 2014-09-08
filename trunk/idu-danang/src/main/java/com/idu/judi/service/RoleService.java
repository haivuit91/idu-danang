package com.idu.judi.service;

import java.util.List;

import com.idu.judi.model.Role;

public interface RoleService {

	/**
	 * Finds all role.
	 * 
	 * @return A list of role.
	 */
	public List<Role> findAll();

	/**
	 * Finds user by roleId.
	 * 
	 * @param id
	 *            The id of the wanted role.
	 * @return The found role. If no role is found, this method returns null.
	 */
	public Role findById(int role);

}
