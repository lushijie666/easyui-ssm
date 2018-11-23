package com.xxx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xxx.model.UserModel;


@Repository
public interface IUserDAO {
	
	int insertUser(UserModel userModel);
	
	int deleteUser(long id);
	
	int updateUser(UserModel userModel);
	
	List<UserModel> getUserList(UserModel userModel);
	
	long getUserCount(UserModel userModel);
	
	UserModel getUser(UserModel userModel);
	
}
