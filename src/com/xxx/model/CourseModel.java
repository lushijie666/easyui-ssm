package com.xxx.model;


import java.io.Serializable;

public class CourseModel extends PaginationModel{
	
	public CourseModel(){}
	
	public CourseModel(String name, int type, int score){
		this.name = name;
		this.type = type;
		this.score = score;
	}

    private Long id;

    private String name;

    private Integer type;

    private Integer score;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}
    
    
}
