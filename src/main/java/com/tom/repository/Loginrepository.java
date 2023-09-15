package com.tom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tom.entity.Login;

public interface Loginrepository extends JpaRepository<Login, Long> {

}
