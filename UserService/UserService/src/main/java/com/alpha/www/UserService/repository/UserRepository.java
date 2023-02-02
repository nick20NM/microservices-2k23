package com.alpha.www.UserService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alpha.www.UserService.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

}
