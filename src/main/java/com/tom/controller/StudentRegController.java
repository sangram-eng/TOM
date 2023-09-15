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


import com.tom.bean.StudentRegInfo;
import com.tom.entity.StudentReg;
import com.tom.exception.UserNotFoundException;
import com.tom.service.StudentRegService;
import com.tom.repository.StudentRegRepo;
@RestController
@RequestMapping("/api/v1/student")
public class StudentRegController {

	@Autowired
	StudentRegService studentRegService;
	@Autowired
	StudentRegRepo studentRegRepo;
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	StudentReg register(@RequestBody StudentRegInfo teacherRegistrationInfo) {
		return studentRegService.register(teacherRegistrationInfo);		
	}
	 @PutMapping("/edit/{id}")
	 StudentReg update(@RequestBody StudentReg newUser, @PathVariable Long id) {
	        return studentRegRepo.findById(id)
	                .map(user -> {
	                    user.setName(newUser.getName());
	                    user.setTeacherId(newUser.getTeacherId());
	                    user.setPhNo(newUser.getPhNo());
	                    user.setEmail(newUser.getEmail());
	                    user.setAddress(newUser.getAddress());
	                    user.setDob(newUser.getDob());
	                    user.setGender(newUser.getGender());
	                    return studentRegRepo.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<StudentReg> getAll(){
		
		return studentRegRepo.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    StudentReg getUserById(@PathVariable Long id) {
        return studentRegRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!studentRegRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        studentRegRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }


}
