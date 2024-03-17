package com.wileyedge.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.wileyedge.Student;


public class StudentRowMapper implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		int age=rs.getInt("age");
		String name=rs.getString("name");
		long mob=rs.getLong("mobile");
		String address=rs.getString("address");
		Student e=new Student(name,age,mob,address);
		return e;
	}

}
