package com.idu.judi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.idu.judi.model.Role;
import com.idu.judi.repository.RoleRepository;
import com.idu.judi.service.RoleService;

public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleRepository roleRepository;

	@Override
	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	@Override
	public Role findById(int role) {
		return roleRepository.findOne(role);
	}

}
