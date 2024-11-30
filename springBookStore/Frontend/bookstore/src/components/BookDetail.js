import React, { useState, useEffect } from 'react';
import { useParams, Link } from 'react-router-dom';
import { Container, Typography, Button } from '@mui/material';
import axios from 'axios';

function BookDetail() {
  const { id } = useParams();
  const [book, setBook] = useState({});

  useEffect(() => {
    // Fetch book details from your backend API
    axios.get(`/api/books/${id}`).then((response) => {
      setBook(response.data);
    });
  }, [id]);

  return (
    <Container>
      <Typography variant="h4" sx={{ mt: 4, mb: 2 }}>
        Book Details
      </Typography>
      <Typography variant="h6">{book.title}</Typography>
      <Typography variant="subtitle1">Author: {book.author}</Typography>
      <Typography variant="body2">Price: ${book.price}</Typography>
      <Typography variant="body2">Category: {book.category}</Typography>
      <Button component={Link} to="/books" variant="contained" sx={{ mt: 2 }}>
        Back to Book List
      </Button>
    </Container>
  );
}

export default BookDetail;
