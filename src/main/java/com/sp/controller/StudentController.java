package com.sp.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sp.entity.Student;
import com.sp.repository.StudentRepository;
import com.sp.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin(origins = "http://localhost:5174")
public class StudentController {

	@Autowired
	private StudentService service;

	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping("/record")
	public List<Student> studentRecordDisplay() {
		List<Student> list = service.displayStudent();
		return list;
	}
	

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long id) {
		if (studentRepo.existsById(id)) {
			studentRepo.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable Long id) {
		return studentRepo.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}
	

	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student student) {
		return studentRepo.findById(id).map(existing -> {
			existing.setName(student.getName());
			existing.setEmail(student.getEmail());
			existing.setCourse(student.getCourse());
			return ResponseEntity.ok(studentRepo.save(existing));
		}).orElse(ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Student createStudent(@RequestBody Student student) {
	    return studentRepo.save(student);
	}


}
