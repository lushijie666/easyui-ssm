package com.xxx.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.dao.IUserDAO;
import com.xxx.model.UserModel;
import com.xxx.util.MD5;
import com.xxx.util.StringUtil;


@Service
public class UserService{

	@Resource
	private IUserDAO userDao;
	
	
	public boolean insertUser(UserModel userModel) {
		boolean result = false;
		String password = userModel.getPassword();
		if(StringUtil.isNotNullString(password)){
			userModel.setPassword(MD5.encode(password));
		}
		int i = userDao.insertUser(userModel);
		if (i == 1){
			result = true; 
		}	
		return result;
	}
	
	public boolean deleteUser(long id) {
		boolean result = false;
		int i = userDao.deleteUser(id);
		if (i == 1){
			result = true;
		}
		return result;
	}
	
	public boolean updateUser(UserModel userModel) {
		String password = userModel.getPassword();
		if(StringUtil.isNotNullString(password)){
			userModel.setPassword(MD5.encode(password));
		}
		boolean result = false;
		int i = userDao.updateUser(userModel);
		if (i == 1){
			result = true;
		}
		return result;
	}
	
	public long getUserCount(UserModel userModel){
		return userDao.getUserCount(userModel);
	}
	
	public List<UserModel> getUserList(UserModel userModel){
		return userDao.getUserList(userModel);
	}
	
}
