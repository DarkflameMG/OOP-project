import { Link } from 'react-router-dom';

const Mainmenu = () =>{
    return(
        <div> 
            <h1> Carin</h1>
            <Link to='/Maingame'>
                 <button className='start-button'>Start</button>
            </Link>
        </div>
    )
}

export default Mainmenu