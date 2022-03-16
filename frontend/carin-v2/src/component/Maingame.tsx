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

const apiStatus = 'http://localhost:8080/api/status'
const apiField = 'http://localhost:8080/api/field'
const apiGameData = 'http://localhost:8080/gamedata'

export type statusType = {
    credit: number,
    num_virus: number,
    num_antibody: number,
}

export type fieldType = {
    costAntibodyB: number,
    x: number,
    y: number,
    costAntibodyA: number,
    costAntibodyC: number,
}

export type gameDataType = {
    virus: number,
    antibody: number,
    credit: number,
    cost: number[],
    posX: number[],
    posY: number[],
    hp: number[],
    hpMax: number[],
    type: number[]
}


const Maingame = () => {
    const [pause, setPause] = useState<boolean>(false);

    const [open, setOpen] = useState(false);
    //--------------Status-------------------------------------------
    const [data, setData] = useState<statusType>();

    //--------------Field-------------------------------------------
    const [fieldData, setField] = useState<fieldType>();
    const [M, setM] = useState<number>();
    const [N, setN] = useState<number>();
    const [costAntibodyA, setCostAntibodyA] = useState<number>();
    const [costAntibodyB, setCostAntibodyB] = useState<number>();
    const [costAntibodyC, setCostAntibodyC] = useState<number>();
    //---------------GameData----------------------------------------
    const [gameData, setGameData] = useState<gameDataType>();
    const [virus, setVirus] = useState<number>();
    const [antibody, setAntibody] = useState<number>();
    const [money, setMoney] = useState<number>();
    const [cost, setCost] = useState<number[]>();
    const [posX, setPosX] = useState<number[]>();
    const [posY, setPosY] = useState<number[]>();
    const [hp, setHp] = useState<number[]>();
    const [hpMax, setHpMax] = useState<number[]>();
    const [type, setType] = useState<number[]>();

    const fetchAll = async () => {
        try {
            const resp = await axios.get<statusType>(apiStatus)
            const resp1 = await axios.get<fieldType>(apiField)
            const resp2 = await axios.get<gameDataType>(apiGameData)
            setData(resp.data)
            setField(resp1.data)
            setGameData(resp2.data)
        } catch (err) {
            console.log(err)
        }
    }

    // const fetchStatus = async () => {
    //     try {
    //         const resp = await axios.get<statusType>(apiStatus)
    //         if (data != resp.data) {
    //             setData(resp.data)
    //             console.log(resp.data)
    //         }
    //     }
    //     catch (err) {
    //         console.log(err)
    //     }
    // }

    // const fetchField = async () => {
    //     try {
    //         const resp1 = await axios.get<fieldType>(apiField)
    //         if (fieldData != resp1.data) {
    //             setField(resp1.data)
    //             console.log(resp1.data)
    //         }
    //     }
    //     catch (err) {
    //         console.log(err)
    //     }
    // }

    // const fetchGameDAta = async () => {
    //     try {
    //         const resp2 = await axios.get<gameDataType>(apiGameData)
    //         if (gameData != resp2.data) {
    //             setGameData(resp2.data)
    //             console.log(resp2.data)
    //         }
    //     }
    //     catch (err) {
    //         console.log(err)
    //     }
    // }

    useEffect(() => {
        setInterval(() => {
            fetchAll()
            // fetchStatus()
            // fetchField()
            // fetchGameDAta()
        }, (100))
    }, [])

    useEffect(() => {
        if (pause != true) {
            if (data != null) {
                setMoney(data.credit)
                
            }
        }
    }, [data])

    useEffect(() => {
        if (pause != true) {
            if (fieldData != null) {
                setM(fieldData.x)
                setN(fieldData.y)
                setCostAntibodyA(fieldData.costAntibodyA)
                setCostAntibodyB(fieldData.costAntibodyB)
                setCostAntibodyC(fieldData.costAntibodyC)
            }
        }
    }, [fieldData])

    useEffect(() => {
        if (pause != true) {
            if (gameData != null) {
                setVirus(gameData.virus)
                setAntibody(gameData.antibody)
                setMoney(gameData.credit)
                setCost(gameData.cost)
                setPosX(gameData.posX)
                setPosY(gameData.posY)
                setHp(gameData.hp)
                setHpMax(gameData.hpMax)
                setType(gameData.type)
            }
        }
    }, [gameData])

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
        setPause(true)
        console.log("pause clicked")
    }

    function unPause() {
        setPause(false)
        console.log("unPause")
    }

    var speedUp = ">>"
    var speedDown = "<<"

    let gameScreenWidth = window.innerWidth - 400
    let gameScreenHeight = window.innerHeight - 200



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
                    <button onClick={clickSpeedDown} className="font-Righteous">Speed down {speedDown}</button>
                    <button onClick={clickSpeedUP} className="font-Righteous">Speed up {speedUp}</button>
                    <button onClick={() => { clickPause(); handleOpen(); }} className='bg-pause font-Righteous'>Pause</button>
                </div>
            </div>

            <div className='flex '>
                {/* shop */}
                <Shop costA={costAntibodyA} costB={costAntibodyB} costC={costAntibodyC} />

                {/* field */}
                <div className='layout-field'>
                    {/* <Field/> */}
                    <TransformWrapper centerOnInit={true} initialScale={0.9} limitToBounds={false} minScale={0.5} maxScale={100} >

                        <TransformComponent >
                            <div className='' style={{ width: gameScreenWidth, height: gameScreenHeight }}>
                                <div className='flex items-center justify-center'>
                                    <Field X={M} Y={N} posX={posX} posY={posY} money={money} hp={hp} hpMax={hpMax} type={type} virus={virus} antibody={antibody}></Field>
                                </div>
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
                                    <button onClick={() => { handleClose(); unPause(); }} className='absolute h-14 w-14 -right-10 -top-7'>
                                        <img src={closeBT}></img>
                                    </button>
                                    <h3 className="text-3xl p-2 text-center font-semibold font-Righteous">
                                        PAUSE
                                    </h3>
                                    {/*body*/}
                                    <div className="flex flex-col px-9 py-2 pause">
                                        <button className="font-Righteous px-3 my-2 " onClick={() => { handleClose(); unPause(); }} >Restart</button>
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