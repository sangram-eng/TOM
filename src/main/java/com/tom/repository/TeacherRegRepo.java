package com.tom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.entity.TeacherReg;

public interface TeacherRegRepo extends JpaRepository<TeacherReg, Long> {

}
