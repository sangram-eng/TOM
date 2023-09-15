package com.tom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tom.bean.StudentRegInfo;
import com.tom.bean.TeacherRegInfo;
import com.tom.entity.StudentReg;
import com.tom.entity.TeacherReg;
import com.tom.repository.StudentRegRepo;
import com.tom.repository.TeacherRegRepo;

@Service
public class StudentRegService {

	
	  
		@Autowired
		StudentRegRepo studentRegRepo;
		
		public StudentReg register(StudentRegInfo studentRegInfo) {
			return studentRegRepo.save(studentRegInfo.convertToEntity());
		}
		
		public StudentReg update(StudentReg StudentReg) {
			return studentRegRepo.save(StudentReg);
		}
		
		public List<StudentReg> getAll() {
			return studentRegRepo.findAll();
		}
		
		public StudentReg getById(Long id) {
			return studentRegRepo.getOne(id);
		}
		
		public void delete(Long id) {
			studentRegRepo.deleteById(id);
		}
		
}
