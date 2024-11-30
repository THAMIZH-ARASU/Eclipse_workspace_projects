package com.coreJava.TreeSetAndTreeMap;

public class Student implements Comparable<Object>{
	private int rollno;
	private String name;
	private float per;
	
	public Student(int rollno, String name, float per) {
		super();
		this.rollno = rollno;
		this.name = name;
		this.per = per;
	}


	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPer() {
		return per;
	}

	public void setPer(float per) {
		this.per = per;
	}


	public int hashCode() {
		final int prime = 31;
		int result = 1;
		
		result = prime * result * (int) per + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	
	@Override 
	//if both the object references are referencing to the same object
	
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if(obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;

		//type casting of the argument
		Student other = (Student)obj;
		
		//comparing the state of the argument with the state of this object
		if(rollno != other.rollno) 
			return false;
		if(name == null) {
			if(other.name != null)		
				return false;
		}else if(!name.equals(other.name))
			return false;
		return true;
	}
	
	public int compareTo(Object o) {
		Student s2 = (Student) o;
		//return (int) (this.rollno - s2.rollno);
		return this.name.compareTo(s2.name);
	}
	
	@Override
	public String toString() {
		return "Student [rollno=" + rollno + ", name=" + name + ", per=" + per + "]";
	}
	
}
