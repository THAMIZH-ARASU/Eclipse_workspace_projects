package com.student.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin
public class StudentController {
	
	@Autowired 
    private final StudentService studentService;

    
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @PostMapping("/add")
    public void saveStudent(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable Long id, @RequestBody Student updatedStudent) {
        // Fetch the existing student by ID
        Student existingStudent = studentService.getStudentById(id);

        if (existingStudent == null) {
            return ResponseEntity.notFound().build();
        }

        // Update the student information
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setAge(updatedStudent.getAge());
        existingStudent.setAddress(updatedStudent.getAddress());
        existingStudent.setEmail(updatedStudent.getEmail());

        // Save the updated student to the database
        studentService.saveStudent(existingStudent);

        return ResponseEntity.ok("Student updated successfully");
    }
}
