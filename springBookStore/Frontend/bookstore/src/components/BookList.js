import React, { useState, useEffect } from 'react';
import { Container, Grid, Card, CardContent, Typography } from '@mui/material';
import axios from 'axios';

function BookList() {
  const [books, setBooks] = useState([]);

  useEffect(() => {
    // Fetch book data from your backend API
    axios.get('/api/books').then((response) => {
      setBooks(response.data);
    });
  }, []);

  return (
    <Container>
      <Typography variant="h4" sx={{ mt: 4, mb: 2 }}>
        Book List
      </Typography>
      <Grid container spacing={2}>
        {books.map((book) => (
          <Grid item key={book.id} xs={12} sm={6} md={4}>
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
    </Container>
  );
}

export default BookList;
