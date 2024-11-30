import React, { useState, useEffect} from 'react';
import Delete from './Delete';
import {Paper} from '@material-ui/core';
import './Stylesheet.css';

function ListStudents() {
    const paperStyle={
      padding:'50px 20px', 
      width:600,
      margin:"20px auto"
    }
  const [students, setStudents] = useState([]);

  useEffect(() => {
    // Fetch the list of students from your backend API
    fetch('http://localhost:8080/api/students')
      .then(response => response.json())
      .then(data => setStudents(data))
      .catch(error => console.error('Error fetching students:', error));
  }, []);

  return (
    <div>
      
      <Paper elevation={3} style={paperStyle}>
      <h1>Student List</h1>
      {students.map(student=>(
        <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}} key={student.id}>
          Student ID: {student.id}<br/>
          Student First name: {student.firstName} <br/>
          Student Last name: {student.lastName} <br/>
          Student Age: {student.age} <br/>
          Student Address: {student.address}<br/>
          <Delete studentId={student.id}/>
        </Paper>
      ))
}
    </Paper>
    </div>
  );
}

export default ListStudents;

