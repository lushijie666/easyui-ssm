package com.xxx.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xxx.model.CourseModel;
import com.xxx.model.UserModel;


@Repository
public interface ICourseDAO {
	
	int insertCourse(CourseModel courseModel);
	
	int deleteCourse(long id);
	
	int updateCourse(CourseModel courseModel);
	
	List<CourseModel> getCourseList(CourseModel courseModel);
	
	Long getCourseCount(CourseModel courseModel);
	
}
