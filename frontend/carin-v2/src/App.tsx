import React from 'react';
import {BrowserRouter, BrowserRouter as Router,Link, Route, Routes} from 'react-router-dom'
import Maingame from './component/Maingame';
import './App.css'
import './style/style-intro.css';

function App() {
  return (
    <body>
    <Router>
      <div>
        <div>
          
          <h1> Carin</h1>
          <Link to='/Maingame'>
            <button className='start-button'>Start</button>
          </Link>
        </div>

        <Routes>
          <Route path='/Maingame' element={<Maingame/>}/>
        </Routes>
      </div>
    </Router>
    </body>
    
  );
}

export default App;
