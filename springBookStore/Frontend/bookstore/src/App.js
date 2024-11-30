import React, { useState, useEffect } from 'react';

import {
  Container,
  Typography,
  Grid,
  Card,
  CardContent,
  TextField,
  Button,
} from '@mui/material';

function App() {
  const [books, setBooks] = useState([]);
  const [newBook, setNewBook] = useState({
    title: '',
    author: '',
    price: '',
    category: '',
  });

  useEffect(() => {
    // Simulated data - Replace with your API call logic
    const fetchData = async () => {
      // Simulate fetching book data from the backend
      const response = await fetch('/api/books');
      const data = await response.json();
      setBooks(data);
    };

    fetchData();
  }, []);

  const handleAddBook = async () => {
    // Simulated data - Replace with your API call logic
    const response = await fetch('/api/books', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(newBook),
    });

    if (response.status === 201) {
      // Book added successfully
      // You can redirect or update the UI as needed
      setBooks([...books, newBook]);
      setNewBook({
        title: '',
        author: '',
        price: '',
        category: '',
      });
    }
  };

  return (
    <Container>
      <Typography variant="h4" sx={{ mt: 4, mb: 2 }}>
        Book List
      </Typography>
      <Grid container spacing={2}>
        {books.map((book, index) => (
          <Grid item key={index} xs={12} sm={6} md={4}>
            <Card>
              <CardContent>
                <Typography variant="h6">{book.title}</Typography>
                <Typography variant="subtitle1">Author: {book.author}</Typography>
                <Typography variant="body2">Price: ${book.price}</Typography>
                <Typography variant="body2">Category: {book.category}</Typography>
              </CardContent>
            </Card>
          </Grid>
        ))}
      </Grid>

      <Typography variant="h4" sx={{ mt: 4, mb: 2 }}>
        Add New Book
      </Typography>
      <TextField
        label="Title"
        fullWidth
        value={newBook.title}
        onChange={(e) => setNewBook({ ...newBook, title: e.target.value })}
        sx={{ mt: 2 }}
      />
      <TextField
        label="Author"
        fullWidth
        value={newBook.author}
        onChange={(e) => setNewBook({ ...newBook, author: e.target.value })}
        sx={{ mt: 2 }}
      />
      <TextField
        label="Price"
        fullWidth
        value={newBook.price}
        onChange={(e) => setNewBook({ ...newBook, price: e.target.value })}
        sx={{ mt: 2 }}
      />
      <TextField
        label="Category"
        fullWidth
        value={newBook.category}
        onChange={(e) => setNewBook({ ...newBook, category: e.target.value })}
        sx={{ mt: 2 }}
      />
      <Button onClick={handleAddBook} variant="contained" sx={{ mt: 2 }}>
        Add Book
      </Button>
    </Container>
  );
}

export default App;
