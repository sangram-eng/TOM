package com.tom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tom.bean.TeacherRegInfo;
import com.tom.entity.TeacherReg;
import com.tom.repository.TeacherRegRepo;


  @Service
  public class TeacherRegService {
	  
	@Autowired
	TeacherRegRepo TeacherRegRepo;
	
	public TeacherReg register(TeacherRegInfo teacherReginfo) {
		return TeacherRegRepo.save(teacherReginfo.convertToEntity());
	}
	
	public TeacherReg update(TeacherReg TeacherReg) {
		return TeacherRegRepo.save(TeacherReg);
	}
	
	public List<TeacherReg> getAll() {
		return TeacherRegRepo.findAll();
	}
	
	public TeacherReg getById(Long id) {
		return TeacherRegRepo.getOne(id);
	}
	
	public void delete(Long id) {
		TeacherRegRepo.deleteById(id);
	}
}
