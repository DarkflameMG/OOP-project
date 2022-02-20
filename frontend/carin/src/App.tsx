import React from 'react';
import logo from './logo.svg';
import IntroGame from './view/MainGame';
import './view/viewStyle.css';
function App() {

  let clickStart = false
  let clickCredit = false
  return (
    // <div style={{backgroundColor: 'blue', 
    //             width: '500px' ,
    //             height: '5000 px'}}>

    <div>
      <body>
        <div className='bg'>
          <h1>Carin</h1>
          {/* <a href="MainGame.tsx" className="start-button"> Start</a> */}
          <button  className="start-button"> Start</button>   //go to MainGame.tsx

        </div>
      </body>
      
    </div>
    
  );
}

export default App;
