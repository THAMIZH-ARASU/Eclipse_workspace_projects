package com.example.demo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Entity;

@Entity
public class Student 
{
	private Integer S_id;
	private String S_name;
	private String S_address;
	
	public Student() {
		super();
	}
	
	public Student(Integer s_id, String s_name, String s_address) 
	{
		super();
		S_id = s_id;
		S_name = s_name;
		S_address = s_address;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getS_id() {
		return S_id;
	}
	public void setS_id(Integer s_id) {
		S_id = s_id;
	}
	public String getS_name() {
		return S_name;
	}
	public void setS_name(String s_name) {
		S_name = s_name;
	}
	public String getS_address() {
		return S_address;
	}
	public void setS_address(String s_address) {
		S_address = s_address;
	}
	@Override
	public String toString()
	{
		return "Student id:"+S_id+" Student name:"+S_name+" Student address"+S_address;
	}
}
