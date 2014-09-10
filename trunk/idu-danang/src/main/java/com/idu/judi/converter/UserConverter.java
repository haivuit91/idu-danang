package com.idu.judi.converter;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import com.idu.judi.model.User;
import com.idu.judi.service.UserService;


@ManagedBean
@RequestScoped
public class UserConverter implements Converter {
	
	@Autowired
	private UserService userService;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		return userService.findById(Integer.valueOf(arg2));
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		try {
			User user =(User)arg2;
			return user.getUserId()+"";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
