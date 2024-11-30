//Program to demonstrate Abstraction
package com.coreJava.Abstraction;

//abstract class
public abstract class Shape {
	protected float area;
	
	//abstract method
	abstract void calArea();
	
	//concrete method
	void show() {
		System.out.println("Area of the shape is " + area);
	}
}
