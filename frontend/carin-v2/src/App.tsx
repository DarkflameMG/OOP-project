import React from 'react';
import {BrowserRouter, BrowserRouter as Router,Link, Route, Routes} from 'react-router-dom'
import Maingame from './component/Maingame';
import './App.css'

function App() {
  return (
    <Router>
      <div>
        <div>
          <h1> Home Page</h1>
          <Link to='/Maingame'>
            <button className='start-button'>Start</button>
          </Link>
        </div>

        <Routes>
          <Route path='/Maingame' element={<Maingame/>}/>
        </Routes>
      </div>
    </Router>
    
  );
}

export default App;
