import { Link } from 'react-router-dom';
import '../style/style-maingame.css';

const Maingame = () => {
    function clickSpeedUP() {
        console.log("speed up clicked")
    }

    function clickSpeedDown() {
        console.log("speed down clicked")
    }

    function clickPause() {
        console.log("pause clicked")
    }

    return (
        <div>
            {/* navbar */}
            <div className="topnav" >
                <div className="topnav-centered">
                    <p className="active">Wave 1/5</p>
                </div>

                <div >
                    <p >Money $100000</p>
                </div>

                <div className="topnav-right">
                    <button onClick={clickSpeedUP}>Speed up</button>
                    <button onClick={clickSpeedDown}>Speed down</button>
                    <button onClick={clickPause} className='bg-pause'>Pause</button>
                </div>
            </div>


            {/* shop */}

            <div className='shop'>
                <p>Shop</p>
                <li><button>antibody A</button></li>
                <li><button>antibody B</button></li>
                <li><button>antibody C</button></li>

            </div>
        </div>
    )
}

export default Maingame