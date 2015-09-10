package com.isd.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.validation.constraints.Size;

import org.apache.bval.constraints.NotEmpty;

@Named
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 578803443296842750L;

	@Size(message = "Имя не должно превышать 4 символа", max = 4)
	@NotEmpty(message = "Имя пользователя обязательно для заполнения")
	private String name;
	@Size(message = "Пароль должен быть не более 10 символов", max = 10)
	@NotEmpty(message = "Пароль обязателен для заполнения")
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
