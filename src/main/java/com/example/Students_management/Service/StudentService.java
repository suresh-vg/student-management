package com.example.Students_management.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Students_management.Dto.Student;
import com.example.Students_management.Repository.studentRepo;

@Service
public class StudentService {
	
	@Autowired
	private studentRepo studentrepo;
	
	public void saveStudent(Student student)
	{
		studentrepo.save(student);
	}
	
	public List<Student> getAllStudents()
	{
		return studentrepo.findAll();
	}
	
	public Student getbyId(int id)
	{
		return studentrepo.findById(id).orElse(null);
	}
	
	public void updateStudent(Student student ,int id)
	{
		Student existstudent=studentrepo.findById(id).orElse(null);
		existstudent.setBranch(student.getBranch());
		existstudent.setGender(student.getGender());
		existstudent.setName(student.getName());
		existstudent.setRno(student.getRno());
		studentrepo.save(existstudent);
	}
	
	public boolean deletebyId(int id)
	{
//		 studentrepo.deleteById(id);
		if (studentrepo.existsById(id)) {
            studentrepo.deleteById(id);
            return true;
        } else {
            return false;
        }
	}
}
