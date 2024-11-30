package com.example.demo;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@jakarta.transaction.Transactional
public class StudentService
{
	@Autowired
	private StudentServiceRepository repo;
	
	public List<Student> listAll()
	{
		return repo.findAll();
	}
	
	public void save(Student stud)
	{
		repo.save(stud);
	}
	public Student get(Integer S_id)
	{
		return repo.findById(S_id).get();
	}
	public void delete(Integer S_id)
	{
		repo.deleteById(S_id);
	}
}
