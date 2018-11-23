package com.xxx.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.dao.ICourseDAO;
import com.xxx.dao.ICourseDAO;
import com.xxx.model.CourseModel;
import com.xxx.model.UserModel;


@Service
public class CourseService{

	@Resource
	private ICourseDAO courseDao;
	
	
	public boolean insertCourse(CourseModel courseModel) {
		boolean result = false;
		int i = courseDao.insertCourse(courseModel);
		if (i == 1){
			result = true; 
		}
		return result;
	}
	
	public boolean deleteCourse(long id) {
		boolean result = false;
		int i = courseDao.deleteCourse(id);
		if (i == 1){
			result = true;
		}
		return result;
	}
	
	public boolean updateCourse(CourseModel courseModel) {
		boolean result = false;
		int i = courseDao.updateCourse(courseModel);
		if (i == 1){
			result = true;
		}
		return result;
	}
	
	public List<CourseModel> getCourseList(CourseModel courseModel) {
		return courseDao.getCourseList(courseModel);
	}
	
	public Long getCourseCount(CourseModel courseModel){
		return courseDao.getCourseCount(courseModel);
	}
	
}
