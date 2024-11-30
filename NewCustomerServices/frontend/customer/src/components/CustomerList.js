import React, { useState, useEffect } from 'react';
import axios from 'axios';

function CustomerList() {
  const [customers, setCustomers] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/customers')
      .then(response => {
        setCustomers(response.data);
      })
      .catch(error => {
        console.error('Error fetching customers: ', error);
      });
  }, []);

  return (
    <div>
      <h1>Customer List</h1>
      <ul>
        {customers.map(customer => (
          <li key={customer.id}>
            <div>Name: {customer.name}</div>
            <div>Email: {customer.email}</div>
            <div>Age: {customer.age}</div>
            <div>Phone Number: {customer.phonenumber}</div>
          </li>
        ))}
          
      </ul>
    </div>
  );
}

export default CustomerList;
