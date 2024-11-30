package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentServiceRepository  extends JpaRepository<Student,Integer>
{

}

