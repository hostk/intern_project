package com.intern.springbootjba.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.intern.springbootjba.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

	public List<Student> findByNameLike(String name);
	
	public List<Student> findByRollNoLike(String rollNo);
	
	/*
	 * public List<Student> findbyAgeBetween(int from,int to);
	 */	
	@Query("select s from Student s where s.name=?1")
	Student findByName(String name);

}
