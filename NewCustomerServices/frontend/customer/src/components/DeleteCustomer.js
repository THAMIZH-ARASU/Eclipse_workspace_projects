import React from 'react';
import axios from 'axios';

function DeleteCustomer({ customer }) {
  const handleDeleteCustomer = () => {
    axios.delete(`http://localhost:8080/api/customers/${customer.id}`)
      .then(() => {})
      .catch(error => {
        console.error('Error deleting customer: ', error);
      });
  };

  return (
    <div>
      <button onClick={handleDeleteCustomer}>Delete</button>
    </div>
  );
}

export default DeleteCustomer;
