package com.idu.judi.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import org.springframework.beans.factory.annotation.Autowired;

import com.idu.judi.model.Role;
import com.idu.judi.service.RoleService;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Integer> {

	@Autowired
	private RoleService roleService;

	@Override
	public Integer convertToDatabaseColumn(Role attribute) {
		// Integer id;
		// if (attribute instanceof Role) {
		// Role role = (Role) attribute;
		// id = role.getRoleId();
		// } else if (attribute instanceof Integer) {
		// id = (Integer) attribute;
		// }
		// return id;
		Role role = (Role) attribute;
		return role.getRoleId();
	}

	@Override
	public Role convertToEntityAttribute(Integer dbData) {
		Role role = null;
		// if (dbData != null) {
		// role = roleService.findById(dbData);
		// role.getRoleId();
		// }
		// return role;

		if (dbData != null) {
			role = roleService.findById(dbData);
		}
		return role;
	}

}