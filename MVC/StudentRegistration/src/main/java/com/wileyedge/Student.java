package com.wileyedge;

public class Student {
	private String name;
	private int age;
	private long mobile;
	private String address;
	
	public Student() {}
	public Student(String name, int age, long mobile, String address) {
		super();
		this.name = name;
		this.age = age;
		this.mobile = mobile;
		this.address = address;
	}
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
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
