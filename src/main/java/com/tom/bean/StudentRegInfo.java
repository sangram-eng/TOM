package com.tom.bean;
import com.tom.entity.StudentReg;

public class StudentRegInfo {

	private String id;
	private String name;
	private String phNo;
	private String teacherId;
	private String email;
	private String address;
	private String dob;
	private String gender;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhNo() {
		return phNo;
	}
	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getTeacherId() {
		return teacherId;
	}
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public StudentReg convertToEntity() 
	 {
		
		StudentReg  studentReg= new  StudentReg();
			if(id!=null  && id!="0")			
		    studentReg.setId(Long.valueOf(id));
			studentReg.setName( name);
			studentReg.setPhNo( phNo);
			studentReg.setEmail( email);
			studentReg.setAddress(address);
			studentReg.setGender(gender);
			studentReg.setTeacherId(teacherId);
			studentReg.setDob(dob);

				return studentReg;
 }
}
