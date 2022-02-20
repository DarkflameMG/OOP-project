import { Link } from 'react-router-dom';
import '../style/style-maingame.css';
import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';

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
                <p className="shop-text">Shop</p>
                <li><button className='antibody-set'>antibody A</button>
                <img src={antibodyA} height={200} width={200} />
                </li>

                <li><button className='antibody-set'>antibody B</button>
                <img src={antibodyB} height={200} width={200} />
                </li>

                <li><button className='antibody-set'>antibody C</button>
                <img src={antibodyC} height={200} width={200} />
                </li>

            </div>
        </div>
    )
}

export default Maingame