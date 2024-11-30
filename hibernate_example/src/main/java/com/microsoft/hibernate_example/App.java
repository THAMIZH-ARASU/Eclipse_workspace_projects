package com.microsoft.hibernate_example;

import java.util.List;
import com.microsoft.DAO.IStudent;
import com.microsoft.DAO.StudentDAO;
import com.microsoft.model.Student;


public class App {
    public static void main(String[] args){
    	IStudent studentDao = new StudentDAO();

        // test saveStudent
        Student student = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
        studentDao.saveStudent(student);

		/*
		  // test updateStudent student.setFirstName("Ram");
		  studentDao.updateStudent(student);
		  
		  // test getStudentById
		  @SuppressWarnings("unused") Student student2 =
		  studentDao.getStudentById(student.getId());
		  
		  // test getAllStudents List < Student > students =
		  studentDao.getAllStudents(); students.forEach(student1 ->
		  System.out.println(student1.getId()));
		  
		  // test deleteStudent studentDao.deleteStudent(student.getId());
		 */

	}
}