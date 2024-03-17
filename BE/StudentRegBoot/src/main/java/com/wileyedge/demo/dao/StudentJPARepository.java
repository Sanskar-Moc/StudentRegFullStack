package com.wileyedge.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wileyedge.demo.model.Student;

@Repository("dataJPADao")
public interface StudentJPARepository extends JpaRepository<Student, Integer>,IDao {

}
