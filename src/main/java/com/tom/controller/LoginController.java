package com.tom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tom.bean.LoginInfo;
import com.tom.entity.Login;
import com.tom.entity.StudentReg;
import com.tom.service.LoginService;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {
	@Autowired
	LoginService LoginService;
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	Login register(@RequestBody LoginInfo LoginInfo) {
		return LoginService.register(LoginInfo);		
	}
	
	@PutMapping("/update/{id}")
	public Login update(@RequestBody Login LoginInfo, @PathVariable("id")Long id)
	{
		return this.LoginService.update(LoginInfo);
	}
	
	@DeleteMapping("/delete/{id}")
	private void deleteStudent(@PathVariable("id")Long id)
	{
		LoginService.delete(id);
	}
	@GetMapping("/getAll")
	
	public List<Login> getAll(){
		
		return LoginService.getAll();
	}
	
    @GetMapping("/getbyid")
	
	public Login getById(@RequestParam("id") Long id){
		
		return LoginService.getById(id);
	}
}
