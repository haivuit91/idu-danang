package com.idu.judi.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.idu.judi.model.Role;
import com.idu.judi.repository.RoleRepository;
import com.idu.judi.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Resource
	private RoleRepository roleRepository;

	@Override
	@Transactional
	public List<Role> findAllRole() {
		return roleRepository.findAll();
	}

	@Override
	@Transactional
	public Role findRoleById(int roleId) {
		return roleRepository.findOne(roleId);
	}

}
