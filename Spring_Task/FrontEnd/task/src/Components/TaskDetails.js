import React from 'react';
import { Button, Typography } from '@mui/material';

function TaskDetails({ onBack, onDelete }) {
    // Replace with actual task data
    const task = { title: 'Task 1', description: 'Description 1' };

    return (
        <div>
            <Typography variant="h4" gutterBottom>
                Task Details
            </Typography>
            <Typography variant="h6">Title: {task.title}</Typography>
            <Typography variant="body1">Description: {task.description}</Typography>
            <Button variant="contained" color="primary" onClick={onBack}>
                Back
            </Button>
            <Button variant="contained" color="secondary" onClick={onDelete}>
                Delete
            </Button>
        </div>
    );
}

export default TaskDetails;
