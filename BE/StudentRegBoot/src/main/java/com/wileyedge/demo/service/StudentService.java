package com.wileyedge.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.wileyedge.demo.dao.IDao;
import com.wileyedge.demo.model.Student;


@Service
public class StudentService implements IService {
	@Autowired
	@Qualifier("dataJPADao")
	private IDao dao;
	
	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	@Override
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id);
	}

	@Override
	public Student save(Student Student) {
		// TODO Auto-generated method stub
		return dao.save(Student);
	}

	@Override
	public Student deleteById(int id) {
		// TODO Auto-generated method stub
		return dao.deleteById(id);
	}

}
