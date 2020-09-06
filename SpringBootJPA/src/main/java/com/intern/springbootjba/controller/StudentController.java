package com.intern.springbootjba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.intern.springbootjba.model.Student;
import com.intern.springbootjba.repository.StudentRepository;

@Controller
public class StudentController  {

	@Autowired
	private StudentRepository repo;
	
	@PostMapping("/add")
	public @ResponseBody String addNewUser(@RequestParam String name,@RequestParam String rollNo) {
		
		Student ss = new Student();
		ss.setName(name);
		ss.setRollNo(rollNo);
		repo.save(ss);
		return "Saved";
	}
	@GetMapping("/creates")
	public String create_Student(Model model) {
	model.addAttribute("student",new Student());
	return "add_student";
}
	@PostMapping("/save_student")
	public String save_student(@ModelAttribute(value="student") Student std,Model model) {
		repo.save(std);
		model.addAttribute("students",repo.findAll());
		return "student_list";
	}
	@GetMapping("/call")
	public @ResponseBody String test() {
		return "Hello Test";
	}
	
	@GetMapping("/std_list/{name}")
	public @ResponseBody List<Student> getStudentListByName(@PathVariable(value="name")String name ){
		List<Student> stdList= repo.findByNameLike(name);
		return stdList;
	}
	
	@GetMapping("/list/{rollNo}")
	public @ResponseBody List<Student> getStudentListByRollNo(@PathVariable(value="rollNo")String name){
		List<Student> stdList=repo.findByRollNoLike(name);
		return stdList;
	}
//	
//	@GetMapping("/list_between/{from}/{to}")
//	public @ResponseBody List<Student> getStudentListByAgeBetween(@PathVariable(value="from")int from, @PathVariable(value="to")int to){
//		List<Student> stdList=repo.findbyAgeBetween(from, to);
//		return stdList;
//	}
//	
	@GetMapping("/find_by_name/{name}")
	public @ResponseBody Student getStudentfindByName(@PathVariable(value="name")String name){
		return repo.findByName(name);
	}
}
