import React, { useState } from 'react';
import axios from 'axios';

function CreateCustomer() {
  const [newCustomer, setNewCustomer] = useState({ name: '', email: '', age: "", phonenumber: "" });

  const handleCreateCustomer = () => {
    axios.post('http://localhost:8080/api/customers', newCustomer)
      .then(() => {console.log("success")})
      .catch(error => {
        console.error('Error creating customer: ', error);
      });
  };

  return (
    <div>
      <input
        type="text"
        placeholder="Name"
        value={newCustomer.name}
        onChange={e => setNewCustomer({ ...newCustomer, name: e.target.value })}
      />
      <input
        type="text"
        placeholder="Email"
        value={newCustomer.email}
        onChange={e => setNewCustomer({ ...newCustomer, email: e.target.value })}
      />
      <input
        type="number"
        placeholder="Age"
        value={newCustomer.age}
        onChange={e => setNewCustomer({ ...newCustomer, age: e.target.value })}
      />
      <input
        type="number"
        placeholder="Phone Number"
        value={newCustomer.phonenumber}
        onChange={e => setNewCustomer({ ...newCustomer, phonenumber: e.target.value })}
      />
      <button onClick={handleCreateCustomer}>Create</button>
    </div>
  );
}

export default CreateCustomer;
