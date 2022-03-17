import axios from "axios";
import { Component, useEffect, useState } from "react";
import { TransformComponent, TransformWrapper } from "react-zoom-pan-pinch"
import { resourceLimits } from "worker_threads";
import square from '../image/square.png';
import slot from '../image/slot.png';
import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';
import virusA from '../image/virusA.png';
import virusB from '../image/virusB.png';
import virusC from '../image/virusC.png';

import { setBuyingUnit , getAntiboody} from './Shop'



function placeObj(props: any) {
    let charactor: any = null;
    let size = props.size
    let height = size * 0.1
    let width = size * 0.8

    ////////////////
    // setBuyingState(false)//สำหรับใส่ Onclick ลงตาราง เพื่อให้สถานะ buying เป็น false
    ////////////////

    if (props.type === 1) {
        charactor = virusA
    } else if (props.type === 2) {
        charactor = virusA
    } else if (props.type === 3) {
        charactor = virusA
    } else if (props.type === 4) {
        charactor = antibodyA
    } else if (props.type === 5) {
        charactor = antibodyB
    } else if (props.type === 6) {
        charactor = antibodyC
    }

    let image: any = null
    if (props.type !== 0)
        image = <img src={charactor} alt="" style={{ height: size }} />
    else
        image = null

}
export type dataType = {
    x: number,
    y: number,
    costAntibodyA: number,
    costAntibodyB: number,
    costAntibodyC: number,
}

const clickPlaceAntibody = (X:number,Y: number) => {

    let placeX = X
    let placeY = Y
    let chooseAntibody = getAntiboody
    console.log("placeAntibody x: " +placeX + " y: " + placeY + " antibody :" + getAntiboody())
    fetch("http://localhost:8080/input/getAntibodyxy", {
        method: "POST",
           headers: {"Content-Type" : "application/json"},
           body: JSON.stringify({ x: placeX, y: placeY, type: getAntiboody() })
       }).then(()=>{
           console.log("send x y of antibody")
       })
    }


const Field = ({ X, Y, posX, posY, hp, hpMax, type, money, virus, antibody }: any) => {

    let m = 0
    let n = 0

    let countVirus = 0
    let countAntibody = 0
    let allUnit = 0

    let positionX = posX
    let positionY = posY
    let Hp = hp
    let maxHp = hpMax
    let Type = type
    let Credit = money

    // console.log("//////////// positionX: "+positionX?.at(0))
    // console.log("//////////// positionY: "+positionY?.at(0))
    // console.log("//////////// Hp: "+Hp?.at(0))
    // console.log("//////////// maxHp: "+maxHp?.at(0))
    // console.log("//////////// Type: "+Type?.at(0))
    // console.log("//////////// Credit: "+Credit)

    if (X != undefined && Y != undefined) {
        m = X
        n = Y
    }

    if (virus != undefined && antibody != undefined) {
        countVirus = virus
        countAntibody = antibody
        allUnit = countVirus + countAntibody

    }

    let maxScale
    let winWidth = window.innerWidth - 400
    let winHeight = window.innerHeight - 200

    let x_scale: number = winWidth / m
    let y_scale: number = winHeight / n
    // console.log("width:" + winWidth)
    // console.log("height:" + winHeight)
    // console.log("x:" + x_scale)
    // console.log("x:" + x_scale)
    // console.log("y:" + y_scale)
    if (n < m) {
        if (y_scale * m <= winWidth) {
            maxScale = y_scale
        } else {
            maxScale = x_scale
        }
    } else {
        if (x_scale * m <= winHeight) {
            maxScale = x_scale
        } else {
            maxScale = y_scale
        }
    }

    // console.log("maxScale: " + Math.round(maxScale))

    maxScale = Math.round(maxScale)
    let setMap: JSX.Element[][] = new Array(n)

    let img = ""
    let indexX = 0;
    let indexY = 0;
    let unitHp = 0;
    let unitMaxHp = 0;
    let getType = 0;
    for (let i = 0; i < n; i++) {
        setMap[i] = new Array(m)
        indexY = positionY?.indexOf(i)
        for (let j = 0; j < m; j++) {
            setMap[i][j] = <button onClick={()=>{clickPlaceAntibody(j,i)}}><img src={slot} alt="" style={{
                position: "relative",
                width: `${maxScale}px`,
                height: `${maxScale}px`,
                margin: 0

            }} /></button>
            for (let k = 0; k < allUnit; k++) {
                indexX = positionX?.at(k)
                indexY = positionY?.at(k)
                if ((indexX == j) && (indexY == i)) {
                    unitHp = Hp?.at(k)
                    unitMaxHp = maxHp?.at(k)
                    getType = Type?.at(k)
                    if (getType == 1) {
                        img = virusA
                    }
                    if (getType == 2) {
                        img = virusB
                    }
                    if (getType == 3) {
                        img = virusC
                    }
                    if (getType == 6) {
                        img = antibodyA
                    }
                    if (getType == 5) {
                        img = antibodyB
                    }
                    if (getType == 4) {
                        img = antibodyC
                    }
                    setMap[i][j] =
                        // <img src={img} alt="" style={{
                        //         position: "relative",
                        //         width: `${maxScale}px`,
                        //         height: `${maxScale}px`,
                        //         margin: 0
                        //         }} />
                
                            <div style={{
                                position: "relative",
                                width: `${maxScale}px`,
                                height: `${maxScale}px`,
                                margin: 0
                            }}>

                                <img src={slot} alt="" style={{
                                    position: "relative",
                                    width: `${maxScale}px`,
                                    height: `${maxScale}px`,
                                    margin: 0
                                }} className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2" />

                                <img src={img} style={{
                                    position: "relative",
                                    width: `${maxScale - (maxScale / 3)}px`,
                                    height: `${maxScale - (maxScale / 3)}px`,
                                    margin: 0
                                }} className="absolute -top-1/2 left-1/2 transform -translate-y-1/2 -translate-x-1/2" />
                                <p className="absolute bottom-1 left-1/2 transform  -translate-x-1/2  font-Righteous text-black font-semibold">
                                    {unitHp}</p>

                            </div>
                        
                }
            }
        }
    }

    return (
        <div>
            {setMap.map((y: JSX.Element[]) => { return <tr>{y.map((x: JSX.Element) => { return <td>{x}</td> })} </tr> })}

        </div>
    )
}

export default Field