package com.coreJava.UserDefinedAnnotation;

@SmartTV(os = "android", height = 40, width = 50)
@SmartPhone(os = "android", version = 12)
public class AndroidSeries {
	String model;
	int screenSize;
	
	public AndroidSeries(String model, int screenSize) {
		
		this.model = model;
		this.screenSize = screenSize;
	}
	
	
}
