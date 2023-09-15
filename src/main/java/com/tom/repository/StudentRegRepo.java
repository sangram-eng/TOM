package com.tom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.entity.StudentReg;

public interface StudentRegRepo extends JpaRepository<StudentReg, Long> {

}
