import React from 'react';
import {BrowserRouter, BrowserRouter as Router,Link, Route, Routes} from 'react-router-dom'
import Maingame from './component/Maingame';
import './App.css'
import Mainmenu from './component/Mainmemu';
import './style/style-intro.css';

function App() {
  return (
  <body>
    <Router>
        <div>
          <Routes>
            <Route path='/' element={<Mainmenu/>}/>
            <Route path='/Maingame' element={<Maingame/>}/>
          </Routes>
        </div>
      </Router>
  </body>
      
  );
}

export default App;
