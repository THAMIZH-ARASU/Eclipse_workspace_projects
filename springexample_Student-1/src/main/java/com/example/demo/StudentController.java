package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.NoResultException;

@RestController
public class StudentController
{
	@Autowired(required=true)
	private StudentService service;
	
	@GetMapping("/studentservice")
	public java.util.List<Student> list()
	{
		return service.listAll();
	}
	
	@GetMapping("/studentservice/{s_id}")
	public ResponseEntity<Student> get(@PathVariable Integer S_id)
	{
		try
		{
			Student stud=service.get(S_id);
			return new ResponseEntity<Student>(stud,HttpStatus.OK);
		}
		catch(NoResultException e)
		{
			return new ResponseEntity<Student>(HttpStatus.NOT_FOUND);
		}
	}
	@PostMapping("/studentservice")
	public void add(@RequestBody Student stud)
	{
		service.save(stud);
	}
	
	@PutMapping("/studentservice/{s_id}")
	public ResponseEntity<?> update(@RequestBody Student stud, @PathVariable Integer S_id)
	{
		Student existstud=service.get(S_id);
		service.save(existstud);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/studentservice/{s_id}")
	public void delete(@PathVariable Integer s_id)
	{
		service.delete(s_id);
	}
}
