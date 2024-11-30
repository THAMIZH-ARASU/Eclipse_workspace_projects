import { Paper } from '@material-ui/core';
import './App.css';
import './Components/Stylesheet.css';
import React from 'react';
import AddStudent from './Components/AddStudents';
import ListStudents from './Components/ListStudents';
import EditStudent from './Components/EditStudent';

function App() {
  return (
    <div className="App">
      <AddStudent/>
      <ListStudents/>
    </div>
  );
}

export default App;
