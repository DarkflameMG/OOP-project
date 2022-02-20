import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import{BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import { Link } from 'react-router-dom';
import Maingame from './component/Maingame';

ReactDOM.render(
  <Router>
    <Routes>
        <Route path='/' element={<Home/>} />
        <Route path='/Maingame' element={<Maingame/>}/>
    </Routes>
  </Router>,
  document.getElementById('root')
);

function Home(){
  return(
    <div className='bg-gray-600 w-full h-full'>
      <div>
        <h1> Home Page</h1>
        <Link to='/Maingame'>
          <button className='start-button'>Start</button>
        </Link>
      </div>
    </div>
  )
}
reportWebVitals();
