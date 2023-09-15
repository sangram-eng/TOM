package com.tom.bean;

import com.tom.entity.TeacherReg;

public class TeacherRegInfo {

	
	private String id;
	private String name;
	private String specialiZationSub;
	private String phNo;
	private String email;
	private String address;
	private String gender;
	private String dob;
	
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

	public String getSpecialiZationSub() {
		return specialiZationSub;
	}

	public void setSpecialiZationSub(String specialiZationSub) {
		this.specialiZationSub = specialiZationSub;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public TeacherReg convertToEntity() {
		
		TeacherReg tr= new TeacherReg();
			if(id!=null  && id!="0")			
			tr.setId(Long.valueOf(id));
			tr.setName( name);
			tr.setSpecialiZationSub(specialiZationSub);
			tr.setEmail(email);
			tr.setPhNo(phNo);
			tr.setAddress(address);
			tr.setGender(gender);
			tr.setDob(dob);
			
			return tr;
		  }
	
}
