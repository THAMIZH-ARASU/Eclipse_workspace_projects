import './Stylesheet.css';
import React from 'react';

function Delete({ studentId, onDelete }) {
  const deleteStyle={
    padding:'5px 10px',
    background:"#dc3545", 
    color:"#fff",
    margin:"20px auto",
    border:"none",
    borderRadius:"4px"
  }

  const handleDelete = () => {
    // Send a DELETE request to your backend API to delete the student
    fetch(`http://localhost:8080/api/students/${studentId}`, {
     method: 'DELETE',
    })
      .then((response) => {
        if (response.status === 200) {
          // Student deleted successfully
          // You can handle success here, such as updating the student list
          console.log("Student record successfully deleted");
          setTimeout(() => { 
            window.location.reload(); 
            }, 300);
          onDelete(studentId);
        } else {
          // Handle errors here (e.g., show an error message)
        }
      })
      .catch((error) => console.error('Error deleting student:', error));
  };

  return (
    <button onClick={handleDelete} style={deleteStyle}>Delete</button>
  );
}

export default Delete;
