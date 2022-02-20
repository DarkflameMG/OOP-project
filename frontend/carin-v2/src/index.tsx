import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import{BrowserRouter as Router, Routes, Route} from 'react-router-dom'
import { Link } from 'react-router-dom';
import Maingame from './component/Maingame';

ReactDOM.render(
  <React.StrictMode>
    <App/>
  </React.StrictMode>,
  document.getElementById('root')
);

reportWebVitals();
