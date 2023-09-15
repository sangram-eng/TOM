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
import org.springframework.web.bind.annotation.RestController;


import com.tom.bean.TeacherRegInfo;

import com.tom.entity.TeacherReg;
import com.tom.exception.UserNotFoundException;
import com.tom.repository.TeacherRegRepo;

import com.tom.service.TeacherRegService;

@RestController
@RequestMapping("/api/v1/teacher")
public class TeacherRegController {

	@Autowired
	TeacherRegService teacherRegService;
	@Autowired
	TeacherRegRepo teacherRegRepo;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	TeacherReg register(@RequestBody TeacherRegInfo teacherRegistrationInfo) {
		return teacherRegService.register(teacherRegistrationInfo);		
	}
	 @PutMapping("/edit/{id}")
	 TeacherReg update(@RequestBody TeacherReg newUser, @PathVariable Long id) {
	        return teacherRegRepo.findById(id)
	                .map(user -> {
	                    user.setName(newUser.getName());
	                    user.setSpecialiZationSub(newUser.getSpecialiZationSub());
	                    user.setPhNo(newUser.getPhNo());
	                    user.setEmail(newUser.getEmail());
	                    user.setAddress(newUser.getAddress());
	                    user.setGender(newUser.getGender());
	                    user.setDob(newUser.getDob());
	                    
	                    return teacherRegRepo.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<TeacherReg> getAll(){
		
		return teacherRegRepo.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    TeacherReg getUserById(@PathVariable Long id) {
        return teacherRegRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!teacherRegRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        teacherRegRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

}
