package com.nt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.UserEntity;

public interface IUserDAO extends JpaRepository<UserEntity, Integer> {

}
