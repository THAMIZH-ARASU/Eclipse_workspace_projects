package com.coreJava.Abstraction;

public class AbstractDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Square s = new Square();
		Rectangle r = new Rectangle();
		s.calArea();
		s.show();
		r.calArea();
		r.show();
		
		System.out.println("--------------------------------------------------------------");
		
		//runtime polymorphism / dynamic binding / late binding
		//ex: method overloading
		
		Shape shape;
		shape = new Square(12.5f);
		
		shape.calArea();
		shape.show();
		
		shape = new Rectangle(10, 20);
		
		shape.calArea();
		shape.show();
		
	}

}
