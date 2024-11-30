import React, { useState, useEffect } from 'react';
import CustomerList from './components/CustomerList';
import CreateCustomer from './components/CreateCustomer';
import EditCustomer from './components/EditCustomer';
import DeleteCustomer from './components/DeleteCustomer'; 
import axios from 'axios';

function App() {
  const [customers, setCustomers] = useState([]);
  const [selectedCustomer, setSelectedCustomer] = useState(null);

  useEffect(() => {
    axios.get('/api/customers')
      .then(response => {
        setCustomers(response.data);
      })
      .catch(error => {
        console.error('Error fetching customers: ', error);
      });
  }, []);

  const handleEditClick = (customer) => {
    setSelectedCustomer(customer);
  };

  const handleDeleteClick = () => {
    setSelectedCustomer(null);
  };

  const handleCreateCustomer = (newCustomer) => {
    axios.post('/api/customers', newCustomer)
      .then(response => {
        setCustomers([...customers, response.data]);
        setSelectedCustomer(null);
      })
      .catch(error => {
        console.error('Error creating customer: ', error);
      });
  };

  const handleUpdateCustomer = (editedCustomer) => {
    axios.put(`/api/customers/${editedCustomer.id}`, editedCustomer)
      .then(() => {
        const updatedCustomers = customers.map(customer =>
          customer.id === editedCustomer.id ? editedCustomer : customer
        );
        setCustomers(updatedCustomers);
        setSelectedCustomer(null);
      })
      .catch(error => {
        console.error('Error updating customer: ', error);
      });
  };

  return (
    <div>
      <CustomerList
        customers={customers}
        onEditClick={handleEditClick}
        onDeleteClick={handleDeleteClick}
      />

      {selectedCustomer ? (
        <>
          <EditCustomer customer={selectedCustomer} onUpdate={handleUpdateCustomer} />
          <DeleteCustomer customer={selectedCustomer} onDelete={handleDeleteClick} />
        </>
      ) : (
        <CreateCustomer onCreate={handleCreateCustomer} />
      )}
    </div>
  );
}

export default App;
