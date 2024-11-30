import { Paper } from '@material-ui/core';
import React, { useState, useEffect } from 'react';

function EditStudent({ studentId, onUpdate }) {
    const paperStyle={
        padding:'50px 20px',
        width:600,
        margin:"20px auto"
    }
    const [student, setStudent] = useState({
    id: null,
    firstName: '',
    lastName: '',
    age: '',
    address: '',
    email: '',
  });

  useEffect(() => {
    // Fetch the student data by ID when the component mounts
    fetch(`http:localhost:8080//api/students/${studentId}`)
      .then(response => response.json())
      .then(data => setStudent(data))
      .catch(error => console.error('Error fetching student:', error));
  }, [studentId]);

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setStudent({
      ...student,
      [name]: value,
    });
  };

  const handleUpdate = (event) => {
    event.preventDefault();

    // Send a PUT request to update the student data
    fetch(`localhost:8080/api/students/${student.id}`, {
      method: 'PUT',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(student),
    })
      .then(response => {
        if (response.status === 200) {
          // Student updated successfully
          // You can handle success here, such as showing a success message
          onUpdate();
          console.log("Record edited");
          setTimeout(() => { 
            window.location.reload(); 
            }, 300);
        } else {
          // Handle errors here (e.g., show an error message)
        }
      })
      .catch(error => console.error('Error updating student:', error));
  };

  return (
    <div>
        <Paper elevation={3} style={paperStyle}>
      <h2>Edit Student</h2>
      <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}}>
      <form onSubmit={handleUpdate}>
        <div>
          <label htmlFor="firstName">First Name:</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            value={student.firstName}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="lastName">Last Name:</label>
          <input
            type="text"
            id="lastName"
            name="lastName"
            value={student.lastName}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={student.email}
            onChange={handleInputChange}
          />
        </div>
        <div>
          <button type="submit">Update Student</button>
        </div>
      </form>
      </Paper>
      </Paper>
    </div>
  );
}

export default EditStudent;
