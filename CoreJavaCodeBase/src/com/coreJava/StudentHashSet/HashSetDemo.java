package com.coreJava.StudentHashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<Student> studentSet = new HashSet<Student>();
		addElements(studentSet);
		System.out.println(studentSet);
	}

	private static void addElements(Set<Student> studentSet) {
		// TODO Auto-generated method stub
		Student s1 = new Student("Pooja", 78);
		studentSet.add(s1);
		s1 = new Student("Nikitha", 66);
		studentSet.add(s1);
		s1 = new Student("Deepa", 73);
		studentSet.add(s1);
		s1 = new Student("Neha", 81);
		studentSet.add(s1);
		s1 = new Student("Neha", 81);
		studentSet.add(s1);//duplicate element can't insert
	}
	
	

}
