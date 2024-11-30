package com.coreJava.UserDefinedAnnotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)

public @interface SmartPhone {
	String os() default "android";
	int version() default 1;
}
