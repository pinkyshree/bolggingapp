package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserName;

@Repository
public interface IUserNameRepository extends JpaRepository<UserName, Integer>{

}
