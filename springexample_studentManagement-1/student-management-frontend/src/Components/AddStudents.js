
import React,{ useState } from 'react';
import { Paper } from '@material-ui/core';
function AddStudent() {
  const paperStyle={
    padding:'50px 20px',
    width:600,
    margin:"20px auto"
  }
  const [student, setStudent] = useState({
    firstName: '',
    lastName: '',
    age: '',
    address: '',
    email: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setStudent({
      ...student,
      [name]: value,
    });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Send a POST request to your backend API to add the student
    fetch('http://localhost:8080/api/students/add', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(student),
    })
      .then((response) => {
        if (response.status === 200) {
          console.log("New student added");
          setTimeout(() => { 
            window.location.reload(); 
            }, 300);
        } else {
          console.log("Some error occurred. Please RETRY after Sometime or reload the page")
        }
      })
      .catch((error) => console.error('Error adding student:', error));
  };

  return (
    <div>
      <Paper elevation={3} style={paperStyle}>
      <h2 >Add Student</h2>
      <Paper elevation={6} style={{margin:"10px",padding:"15px", textAlign:"left"}}>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="firstName">First Name:</label>
          <input
            type="text"
            id="firstName"
            name="firstName"
            value={student.firstName}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="lastName">Last Name:</label>
          <input
            type="text"
            id="lastName"
            name="lastName"
            value={student.lastName}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="age">Age:</label>
          <input
            type="text"
            id="age"
            name="age"
            value={student.age}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="address">Address:</label>
          <input
            type="text"
            id="address"
            name="address"
            value={student.address}
            onChange={handleChange}
          />
        </div>
        <div>
          <label htmlFor="email">Email:</label>
          <input
            type="email"
            id="email"
            name="email"
            value={student.email}
            onChange={handleChange}
          />
        </div>
        <div>
          <button type="submit">Add Student</button>
        </div>
      </form>
      </Paper>
      </Paper>
    </div>
  );
}

export default AddStudent;
