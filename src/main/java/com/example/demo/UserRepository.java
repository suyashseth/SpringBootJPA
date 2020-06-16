package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.UserEntity;


public interface UserRepository extends CrudRepository<UserEntity, Long>{
	

}
