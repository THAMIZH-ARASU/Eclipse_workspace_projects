import React from 'react';
import { Button, List, ListItem, ListItemText, Typography } from '@mui/material';

function TaskList({ onAddTask }) {
    // Replace with actual task data
    const tasks = [
        { id: 1, title: 'Task 1', description: 'Description 1' },
        { id: 2, title: 'Task 2', description: 'Description 2' },
        { id: 3, title: 'Task 3', description: 'Description 3' },
    ];

    return (
        <div>
            <Typography variant="h4" gutterBottom>
                Task List
            </Typography>
            <List>
                {tasks.map((task) => (
                    <ListItem key={task.id}>
                        <ListItemText primary={task.title} secondary={task.description} />
                        <Button onClick={() => onAddTask(task.id)}>View Details</Button>
                    </ListItem>
                ))}
            </List>
        </div>
    );
}

export default TaskList;
