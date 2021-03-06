import { useState } from "react";
import credit from '../image/CreditButton.png'
import closeBT from '../image/CloseBTmini.png'

const Credit = () =>{
    const [open, setOpen] = useState(false);
    const handleOpen = ()=>{
        setOpen(true);
    }
    const handleClose = ()=>{
        setOpen(false);
    }

    return (
        <div>
            <div  className='absolute bottom-0 right-0 m-auto'>
            <button onClick={handleOpen}>
                <img src={credit}></img>
            </button>
        </div>
        {open ? (
                <>
                <div className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none">
                    <div className="relative w-auto my-6 mx-auto max-w-3xl flex flex-col">
                        <div className='flex'>
                            {/*content*/}
                            <div className="border-4 border-black rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
                                {/*header*/}
                                <button onClick={handleClose} className='absolute h-14 w-14 -right-10 -top-7'>
                                    <img src={closeBT}></img>
                                </button>
                                <h3 className="text-3xl p-2 text-center font-semibold font-Righteous">
                                    Credit
                                </h3>
                                {/*body*/}
                                <div className="relative px-6 flex-auto flex-col">
                                    <p className="my-4 text-black text-xl font-semibold font-Righteous">
                                        1.Khanitin Saenkan (Bank) 630610718
                                    </p>
                                    <p className="my-4 text-black text-xl font-semibold font-Righteous">
                                        2.Lapasrada Kumjulla (Ploy) 630610757
                                    </p>
                                    <p className="my-4 text-black text-xl font-semibold font-Righteous">
                                        3.Winnapat Kaewmora (Game) 630610761
                                    </p>
                                </div>    
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

export default Credit