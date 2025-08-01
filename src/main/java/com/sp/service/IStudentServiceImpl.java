package com.sp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sp.entity.Student;
import com.sp.repository.StudentRepository;

@Service
public class IStudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Override
	public List<Student> displayStudent() {
		return studentRepo.findAll();
	}

}
