import { Link } from 'react-router-dom';
import { TransformWrapper, TransformComponent } from "react-zoom-pan-pinch";
import '../style/style-maingame.css';
import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';
import closeBT from '../image/CloseBTmini.png'
import { useEffect, useState } from 'react';
import Shop from './Shop';
import axios from 'axios';
import Field from './Field';

const Test = 'http://localhost:8080/api/status' 

export type TestFech = {
    credit : number,
    num_virus : number,
    num_antibody : number,
}

const Maingame = () => {
    const [open, setOpen] = useState(false);
    const [data,setData] = useState<TestFech>();
    const [money, setMoney] = useState<number>();
    const [virus, setVirus] = useState<number>();
    const [antibody, setAntibody] = useState<number>();

    const fetchTest = async() =>{
        try{
            const resp = await axios.get<TestFech>(Test) 
            setData(resp.data)
            console.log(data)
        }
        catch(err){
            console.log(err) 
        }
    }

    useEffect(()=>{
        fetchTest()
        if(data != null){
            setMoney(data.credit)
            setVirus(data.num_virus)
            setAntibody(data.num_antibody)
            console.log(data)
            console.log(money)
            console.log(virus)
            console.log(antibody)
        }
    },[])


    const handleOpen = () => {
        setOpen(true);
    }
    const handleClose = () => {
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

    const buyAntigen = (anti: any) =>{
        if(anti === 1 || anti === "A"){
            setMoney(money);
        }
        if(anti === 2 || anti === "B"){
            setMoney(money);
        }
        if(anti === 3 || anti === "C"){
            setMoney(money);
        }
    }

    var speedUp= ">>"
    var speedDown = "<<"


    

    return (
        <div>
            {/* navbar */}
            <div className="topnav" >
                <div className="topnav-centered">
                            <p className="active font-Righteous">Antibody: {antibody} / Virus: {virus} </p>                        
                </div>
                
                <div >
                    <p className="font-Righteous mx-7 ">Money: {money} $</p>
                </div>

                <div className="topnav-right">
                    <button onClick={clickSpeedUP} className="font-Righteous">Speed up {speedUp}</button>
                    <button onClick={clickSpeedDown} className="font-Righteous">Speed down {speedDown}</button>
                    <button onClick={() => { clickPause(); handleOpen(); }} className='bg-pause font-Righteous'>Pause</button>
                </div>
            </div>

            <div className='flex '>
                {/* shop */}
                <Shop/>    

                {/* field */}
                <div className='layout-field'>
                    {/* <Field/> */}
                    <TransformWrapper>
                        <TransformComponent>
                            <div className='container field'>
                                {Field()} 
                            </div>
                        </TransformComponent>
                    </TransformWrapper>

                </div>
                
            </div>
            
            {/**Modal */}
            {open ? (
                <>
                    <div
                        className="justify-center items-center flex overflow-x-hidden overflow-y-auto fixed inset-0 z-50 outline-none focus:outline-none"
                    >
                        <div className="relative w-auto my-6 mx-auto max-w-3xl flex flex-col">
                            <div className='flex'>
                                {/*content*/}
                                <div className="border-4 border-black rounded-lg shadow-lg relative flex flex-col w-full bg-white outline-none focus:outline-none">
                                    {/*header*/}
                                    <button onClick={handleClose} className='absolute h-14 w-14 -right-10 -top-7'>
                                        <img src={closeBT}></img>
                                    </button>
                                    <h3 className="text-3xl p-2 text-center font-semibold font-Righteous">
                                        PAUSE
                                    </h3>
                                    {/*body*/}
                                    <div className="flex flex-col px-9 py-2 pause">
                                        <button className="font-Righteous px-3 my-2 " onClick={handleClose}>Restart</button>
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