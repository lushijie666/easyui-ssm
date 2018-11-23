package com.xxx.model;


public class UserModel extends PaginationModel{
	
	public UserModel(){
	}
	
	public UserModel(String name, int age, String job){
		this.name = name;
		this.age = age;
		this.job = job;
	}

    private Long id;

    private String name;

    private Integer age;

    private String job;
    
    private String password;
    
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    
}
