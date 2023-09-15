package com.tom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tom.bean.LoginInfo;
import com.tom.entity.Login;
import com.tom.repository.Loginrepository;

@Service
public class LoginService {
	  
	@Autowired
	Loginrepository Loginrepository;
	
	public Login register(LoginInfo LoginInfo) {
		return Loginrepository.save(LoginInfo.convertToEntity());
	}
	
	public Login update(Login loginInfo) {
		return Loginrepository.save(loginInfo);
	}
	
	public List<Login> getAll() {
		return Loginrepository.findAll();
	}
	
	public Login getById(Long id) {
		return Loginrepository.getOne(id);
	}
	
	public void delete(Long id) {
		Loginrepository.deleteById(id);
	}
}
