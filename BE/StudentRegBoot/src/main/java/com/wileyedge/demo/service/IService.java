package com.wileyedge.demo.service;

import java.util.List;
import java.util.Optional;

import com.wileyedge.demo.model.Student;



public interface IService {
	public List<Student> findAll();
	Optional<Student> findById(int id);
	public Student save(Student Student);
	public Student deleteById(int id);
}
