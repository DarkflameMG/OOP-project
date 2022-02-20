import React from 'react';
import {BrowserRouter, BrowserRouter as Router,Link, Route, Routes} from 'react-router-dom'
import Maingame from './component/Maingame';

function App() {
  return (
    <div>
      <Maingame/>
      <Routes>
        <Route path='/main'>
          <p>main</p>
        </Route>
      </Routes>
    </div>
    
  );
}

export default App;
