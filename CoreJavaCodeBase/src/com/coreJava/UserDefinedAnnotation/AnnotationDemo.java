package com.coreJava.UserDefinedAnnotation;

import java.lang.annotation.Annotation;

public class AnnotationDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AndroidSeries o = new AndroidSeries("A23", 14);
		System.out.println(o.model);
		System.out.println(o.screenSize);
		
		System.out.println("SmartPhone Details: ");
		
		@SuppressWarnings("rawtypes")
		Class c = o.getClass();
		
		@SuppressWarnings("unchecked")
		Annotation a = c.getAnnotation(SmartPhone.class);
		
		SmartPhone s = (SmartPhone) a;
		
		System.out.println(s.os());
		System.out.println(s.version());
		
		System.out.println("SmartTV details: ");
		
		@SuppressWarnings("unchecked")
		Annotation a1 = c.getAnnotation(SmartPhone.class);
		
		SmartTV s1 = (SmartTV) a1;
		
		System.out.println(s1.os());
		System.out.println(s1.height());
		System.out.println(s1.width());
	}

}
