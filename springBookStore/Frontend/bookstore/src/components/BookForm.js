import React, { useState } from 'react';
import { Container, Typography, TextField, Button } from '@mui/material';
import axios from 'axios';

function BookForm() {
  const [newBook, setNewBook] = useState({
    title: '',
    author: '',
    price: '',
    category: '',
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setNewBook({ ...newBook, [name]: value });
  };

  const handleSubmit = () => {
    // Send a POST request to add the new book to the backend
    axios.post('/api/books', newBook).then(() => {
      // Redirect to the book list page or perform other actions
    });
  };

  return (
    <Container>
      <Typography variant="h4" sx={{ mt: 4, mb: 2 }}>
        Add New Book
      </Typography>
      <TextField
        name="title"
        label="Title"
        fullWidth
        value={newBook.title}
        onChange={handleChange}
        sx={{ mt: 2 }}
      />
      <TextField
        name="author"
        label="Author"
        fullWidth
        value={newBook.author}
        onChange={handleChange}
        sx={{ mt: 2 }}
      />
      <TextField
        name="price"
        label="Price"
        fullWidth
        value={newBook.price}
        onChange={handleChange}
        sx={{ mt: 2 }}
      />
      <TextField
        name="category"
        label="Category"
        fullWidth
        value={newBook.category}
        onChange={handleChange}
        sx={{ mt: 2 }}
      />
      <Button onClick={handleSubmit} variant="contained" sx={{ mt: 2 }}>
        Add Book
      </Button>
    </Container>
  );
}

export default BookForm;
