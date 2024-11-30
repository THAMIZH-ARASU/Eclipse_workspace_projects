import React, { useState } from 'react';
import { AppBar, Container, CssBaseline, Toolbar, Typography } from '@mui/material';
import TaskList from './Components/TaskList';
import TaskForm from './Components/TaskForm';
import TaskDetails from './Components/TaskDetails';

function App() {
    const [currentPage, setCurrentPage] = useState('taskList');

    const handlePageChange = (page) => {
        setCurrentPage(page);
    };

    return (
        <div>
            <CssBaseline />
            <AppBar position="static">
                <Toolbar>
                    <Typography variant="h6">Task Manager</Typography>
                </Toolbar>
            </AppBar>
            <Container>
                {currentPage === 'taskList' && <TaskList onAddTask={() => handlePageChange('taskForm')} />}
                {currentPage === 'taskForm' && (
                    <TaskForm
                        onCancel={() => handlePageChange('taskList')}
                        onSave={() => handlePageChange('taskList')}
                    />
                )}
                {currentPage === 'taskDetails' && (
                    <TaskDetails
                        onBack={() => handlePageChange('taskList')}
                        onDelete={() => handlePageChange('taskList')}
                    />
                )}
            </Container>
        </div>
    );
}

export default App;
