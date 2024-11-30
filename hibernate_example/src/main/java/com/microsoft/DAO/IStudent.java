package com.microsoft.DAO;

import java.util.List;
import com.microsoft.model.Student;

public interface IStudent {
	void saveStudent(Student student);

	 void updateStudent(Student student);

	 Student getStudentById(long id);

	 List<Student> getAllStudents();

	 void deleteStudent(long id);

}
