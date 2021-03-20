package com.jmpc.model;

public class User {
	
	private String name;
	private String certification;
	public User() {
		super();
	}
	private int marks;
	public User(String name, String certification, int marks) {
		super();
		this.name = name;
		this.certification = certification;
		this.marks = marks;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCertification() {
		return certification;
	}
	public void setCertification(String certification) {
		this.certification = certification;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	public boolean getResult() {
		if (this.marks < 60) {
			return false;
		} else {
			return true;
		}
	}
	@Override
	public String toString() {
		return "User [name=" + name + ", certification=" + certification + ", marks=" + marks + "]";
	}
	
	

}
