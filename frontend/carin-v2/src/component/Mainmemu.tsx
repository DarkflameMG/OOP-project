import { Link } from 'react-router-dom';
import logo from '../image/Logo.png'
import startBT from '../image/startButton.png'
import virus from '../image/virusLogo.png'
import virusB from '../image/virusLogoB.png'
import credit from '../image/CreditButton.png'
import closeBT from '../image/CloseBTmini.png'
import '../style/style-font.css'
import { useState } from 'react';
import Credit from './Credit';

const Mainmenu = () =>{
    return(
        <div>
            <div className='m-auto max-w-4xl '> 
                <div className='flex justify-center py-20 '>
                    <img src={logo}></img>
                </div>
                <div className='flex justify-around space-x-10'>
                    <img src={virusB}></img>
                    <Link to='/Maingame'>
                        <img src={startBT} ></img>
                    </Link>
                    <img src={virus}></img>
                </div>
            </div>
            <Credit/>
        </div>    
    )
}

export default Mainmenu