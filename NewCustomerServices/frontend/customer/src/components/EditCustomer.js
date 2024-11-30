import React, { useState } from 'react';
import axios from 'axios';

function EditCustomer({ customer }) {
  const [editCustomer, setEditCustomer] = useState({ ...customer });

  const handleEditCustomer = () => {
    axios.put(`http://localhost:8080/api/customers/${customer.id}`, editCustomer)
      .then(() => {})
      .catch(error => {
        console.error('Error updating customer: ', error);
      });
  };

  return (
    <div>
      <input
        type="text"
        placeholder="Name"
        value={editCustomer.name}
        onChange={e => setEditCustomer({ ...editCustomer, name: e.target.value })}
      />
      <input
        type="text"
        placeholder="Email"
        value={editCustomer.email}
        onChange={e => setEditCustomer({ ...editCustomer, email: e.target.value })}
      />
      <input
        type="text"
        placeholder="Age"
        value={editCustomer.age}
        onChange={e => setEditCustomer({ ...editCustomer, age: e.target.value })}
      />
      <input
        type="text"
        placeholder="Phone Number"
        value={editCustomer.phoneNumber}
        onChange={e => setEditCustomer({ ...editCustomer, phoneNumber: e.target.value })}
      />
      <button onClick={handleEditCustomer}>Update</button>
    </div>
  );
}

export default EditCustomer;
