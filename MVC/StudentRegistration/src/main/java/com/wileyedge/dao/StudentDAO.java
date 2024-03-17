package com.wileyedge.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wileyedge.Student;
import com.wileyedge.service.StudentRowMapper;




@Repository(value="dao")
public class StudentDAO implements IDao {
	
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public Student save(Student e) {
		String sql = "INSERT INTO students (name, age, mobile, address) VALUES (?, ?, ?, ?)";
		template.update(sql,e.getName(),e.getAge(),e.getMobile(),e.getAddress());
		return e;
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Student> findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
