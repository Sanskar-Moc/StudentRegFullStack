package com.wileyedge.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	@Value("101")
	private int id;
	@Value("Sanskar")
	private String name;
	Employee(){
		System.out.println("Inside defauly constructor");
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
}
