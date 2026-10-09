package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.StudentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService {
	private final StudentRepository studentRepository;
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	public List<Student> getAllStudents(){
		return studentRepository.findAll();
	}
	public Student getStudentById(Long id) {
		return studentRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Student not found"));
	}
	public Student updateStudent(Long id,Student student) {
		Student existing=getStudentById(id);
		existing.setName(student.getName());
		existing.setPhone(student.getPhone());
		existing.setEmail(student.getEmail());
		existing.setCollege(student.getCollege());
		return studentRepository.save(existing);
		
	}
	public void deleteStudent(Long id) {
		studentRepository.delete(getStudentById(id));
	}
	

}
