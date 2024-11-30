package com.coreJava.Hashset;

import java.util.HashSet;
import java.util.Spliterator;

public class HashSetDemo {
	
	static void addElements(HashSet<Integer> numberHashSet) {
		numberHashSet.add(61);
		numberHashSet.add(41);
		numberHashSet.add(91);
		numberHashSet.add(51);
		numberHashSet.add(80);
		numberHashSet.add(11);
		numberHashSet.add(20);
		 System.out.println(numberHashSet.add(51));//returns false - not allow to insert duplicate element
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet <Integer> numberHashSet = new HashSet<Integer>();
		addElements(numberHashSet);
		
		HashSet <Integer> numberHashSet_1 = new HashSet<Integer>();
		numberHashSet_1.add(20);
		numberHashSet_1.add(80);
		numberHashSet_1.add(11);
		numberHashSet_1.add(50);
		numberHashSet_1.add(60);
		numberHashSet_1.add(10);
		numberHashSet_1.add(51);
		
		System.out.println("Set 1 : " + numberHashSet);
		System.out.println("Set2 : " + numberHashSet_1);
		
		HashSet<Integer> numberHashSet_2 = new HashSet<Integer>();
		addElements(numberHashSet_2);
		
		//Union of two sets
		numberHashSet_2.addAll(numberHashSet_1);
		System.out.println("Resultant Set (Union): " + numberHashSet_2);
		
		numberHashSet_2.clear();
		addElements(numberHashSet_2);
		
		//Set Difference
		numberHashSet_2.removeAll(numberHashSet_1);
		System.out.println("Resultant Set (Difference): " + numberHashSet_1);
		
		//SplitIterator
		Spliterator<Integer> split = numberHashSet.spliterator();
		split.forEachRemaining(System.out::println);
		
		
		
	}

}
