import React from 'react';
import { Button, TextField, Typography } from '@mui/material';

function TaskForm({ onCancel, onSave }) {
    return (
        <div>
            <Typography variant="h4" gutterBottom>
                Create Task
            </Typography>
            <form>
                <TextField name="title" label="Title" variant="outlined" fullWidth margin="normal" />
                <TextField name="description" label="Description" variant="outlined" fullWidth margin="normal" />
                <Button variant="contained" color="primary" onClick={onSave}>
                    Save
                </Button>
                <Button variant="contained" onClick={onCancel}>
                    Cancel
                </Button>
            </form>
        </div>
    );
}

export default TaskForm;
