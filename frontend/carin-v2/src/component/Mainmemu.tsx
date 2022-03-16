import { useState } from 'react';
import { Link } from 'react-router-dom';
import startBT from '../image/startButton.png'
import '../style/style-font.css'
import Credit from './Credit';



const Mainmenu = () => {

    const startClick = () => {
       const startGame = true
       console.log("start game: "+ startGame)
       fetch("http://localhost:8080/input/startgame", {
           method: "POST",
           headers: {"Content-Type" : "application/json"},
           body: JSON.stringify(startGame)
       }).then(()=>{
           console.log("Start game")
       })
    }
    return (
        <div>
            <div className='m-auto max-w-4xl '>
                <div className='flex justify-center py-20 name-game font-Righteous'>
                    {/* <img src={logo}></img> */}
                    <p>C A R I N</p>

                </div>
                <div className='flex justify-around space-x-10 start-button'>
                    {/* <img src={virusB}></img> */}
                    <button onClick={()=> {startClick();}}>
                        <Link to='/Maingame'>
                        <img src={startBT} ></img>
                    </Link>
                    {/* <img src={virus}></img> */}
                    </button>
                    
                </div>
            </div>
            <Credit />
        </div>
    )
}

export default Mainmenu