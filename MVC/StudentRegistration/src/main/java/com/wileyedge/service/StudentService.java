package com.wileyedge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wileyedge.Student;
import com.wileyedge.dao.IDao;


//@Component(value="service")
@Service(value = "service")
public class StudentService implements IService {
	@Autowired
	private IDao dao;
	
	
	
	public void saveStudents(List<Student> empList) {
//		System.out.println("Inside Service Layer");
		for(Student e : empList) {
			dao.save(e);
		}
	}

}
