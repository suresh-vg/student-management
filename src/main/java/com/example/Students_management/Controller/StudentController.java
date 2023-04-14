package com.example.Students_management.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Students_management.Dto.Student;
import com.example.Students_management.Service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/save")
	public ResponseEntity<Student> addStudent(@RequestBody Student student)
	{
		studentService.saveStudent(student);
		 return ResponseEntity.status(HttpStatus.CREATED).body(student);
		
	}
	
	@GetMapping("/All")
	public List<Student> getAll()
	{
		return studentService.getAllStudents();
	}
	@GetMapping("/{id}")
	public Student getbyid(@PathVariable int id)
	{
		return studentService.getbyId(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletebyId(@PathVariable int id)
	{
	     boolean student=studentService.deletebyId(id);
	     
//	     return ResponseEntity.status(HttpStatus.OK).body(studentService.getbyId(id));
	     if(student==true)
	     {
	     Student student1 = studentService.getbyId(id);
	     String response="student details"+student1+"deleted successfully";
	     return ResponseEntity.ok(response);
	     }
	     else
	     {
	    	   return ResponseEntity.ok("Not found");
	     }
	}
	
	@PutMapping("update/{id}")
	public ResponseEntity<Student>updateStudent(@RequestBody Student student,@PathVariable int id)
	{
		studentService.updateStudent(student, id);
		 return ResponseEntity.status(HttpStatus.CREATED).body(student);
	}
}
