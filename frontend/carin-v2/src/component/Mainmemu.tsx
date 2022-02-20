import { Link } from 'react-router-dom';
import '../style/style-intro.css';


const Mainmenu = () =>{
    return(
        <div > 
            <h1 className="name-game"> Carin</h1>
            <Link to='/Maingame'>
                 <button className='start-button'>Start</button>
            </Link>
        </div>
    )
}

export default Mainmenu