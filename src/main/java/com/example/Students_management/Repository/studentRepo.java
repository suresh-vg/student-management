package com.example.Students_management.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Students_management.Dto.Student;

@Repository
public interface studentRepo extends JpaRepository<Student, Integer> {
	
	

}
