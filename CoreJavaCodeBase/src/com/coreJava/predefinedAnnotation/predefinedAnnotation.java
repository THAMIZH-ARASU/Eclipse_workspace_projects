package com.coreJava.predefinedAnnotation;

import java.util.ArrayList;
import java.util.List;

public class predefinedAnnotation {
	
	@SuppressWarnings(value = {"unchecked"})
	
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		List a = new ArrayList();
		Student s  = new Student(2,"thamizh", "ece");
		a.add(10);
		a.add(22.22f);
		a.add(new Student(1, "arasu", "cse"));
		a.add("SKSJIT");
		a.add(s);
		
		System.out.println("List: " + a);
	}
}
