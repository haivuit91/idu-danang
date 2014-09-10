package com.idu.judi.converter;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;

import com.idu.judi.model.Role;
import com.idu.judi.service.RoleService;

@ManagedBean
@RequestScoped
public class RoleConverter implements Converter {

	@Autowired
	private RoleService roleService;
	

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		System.out.println("str:" + arg2);
		if(roleService == null)
			System.out.println("nukk");
		else
			System.out.println("ok");
		//return roleService.findRoleById(Integer.valueOf(arg2));
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		try {
			Role role = (Role) arg2;
			return role.getRoleId() + "";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}