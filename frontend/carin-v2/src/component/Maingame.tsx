import { Link } from 'react-router-dom';
import '../style/style-maingame.css';
import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';
import closeBT from '../image/CloseBTmini.png'
import { useState } from 'react';

const Maingame = () => {
    const [open, setOpen] = useState(false);
    const handleOpen = ()=>{
        setOpen(true);
    }
    const handleClose = ()=>{
        setOpen(false);
    }
    
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
                    <p className="active font-Righteous">Wave 1/5</p>
                </div>

                <div >
                    <p className="font-Righteous">Money $100000</p>
                </div>

                <div className="topnav-right">
                    <button onClick={clickSpeedUP} className="font-Righteous">Speed up</button>
                    <button onClick={clickSpeedDown} className="font-Righteous">Speed down</button>
                    <button onClick={()=> {clickPause(); handleOpen();}} className='bg-pause font-Righteous'>Pause</button>
                </div>
            </div>


            {/* shop */}

            <div className='shop'>
                <p className="shop-text font-Righteous">Shop</p>
                <li><button className='antibody-set font-Righteous'>antibody A</button>
                <img src={antibodyA} height={200} width={200} />
                </li>

                <li><button className='antibody-set font-Righteous'>antibody B</button>
                <img src={antibodyB} height={200} width={200} />
                </li>

                <li><button className='antibody-set font-Righteous'>antibody C</button>
                <img src={antibodyC} height={200} width={200} />
                </li>

            </div>
            
            {/**Modal */}
            {open ? (
        <>
          <div
            className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none"
          >
            <div className="relative w-auto my-6 mx-auto max-w-3xl flex flex-col">
                <div className='flex justify-end'>
                    <button onClick={handleClose}>
                        <img src={closeBT}></img>
                    </button>
                </div>
                <div className='flex'>
                    {/*content*/}
                    <div className="border-4 border-black rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
                        {/*header*/}
                        <h3 className="text-3xl p-2 text-center font-semibold font-Righteous">
                            PAUSE
                        </h3>
                        {/*body*/}
                        <div className="flex flex-col px-6 ">
                            <button className="font-Righteous" onClick={handleClose}>Resume</button>
                            <button className="font-Righteous">
                                <Link to='/'>
                                    Quit
                                </Link>
                            </button>
                            
                        </div>    
                    </div>
                    <div className=''>
                        <p className='text-transparent px-4'>S</p>
                    </div>
                </div>
            </div>
          </div>
          {/*set bg more white */}
          <div className="opacity-30 fixed inset-0 z-40 bg-white"></div>
        </>
      ) : null}
        </div>

        

    )
}

export default Maingame