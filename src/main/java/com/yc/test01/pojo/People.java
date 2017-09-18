package com.yc.test01.pojo;

import java.io.Serializable;


public class People implements Serializable {

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1546782908601362520L;
	
	private String name ;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public People(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
}
