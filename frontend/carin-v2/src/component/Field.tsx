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

import {setBuyingState} from './Shop'


function placeObj(props: any){
    let charactor: any = null;
    let size = props.size
    let height = size*0.1
    let width = size*0.8

    ////////////////
    // setBuyingState(false)//สำหรับใส่ Onclick ลงตาราง เพื่อให้สถานะ buying เป็น false
    ////////////////

    if (props.type === 1) {
        charactor= virusA
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

    // return (
    //     <div>
    //         <div>
    //                 {props.type !== 0 && <progress className='' style={{ transform: "translate(-50%,-80%)", height: height, width: width }} value={props.hp} max={props.hpMax}></progress>}
    //             </div>
    //             <div>
    //                 {image}
    //             </div>
    //     </div>
    // )

}
export type dataType = {
    x : number,
    y : number,
    costAntibodyA : number,
    costAntibodyB : number,
    costAntibodyC : number,
}

const Field = ({X,Y,posX,posY,hp,hpMax,type,money}:any) => {

    let m = 0
    let n = 0

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

    if(X != undefined && Y != undefined){
        m = X
        n = Y
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

    console.log("maxScale: " + Math.round(maxScale))
    
    maxScale = Math.round(maxScale)
    let setMap: JSX.Element[][] = new Array(n)

    
    

    for (let i = 0; i < n; i++) {
        setMap[i] = new Array(m)
        for (let j = 0; j < m; j++) {
            
            if(posX.indexOf(j) == posY.indexOf(i)){
                let img = ""
                if(type.at(posX.indexOf(j)) == 1){
                    img = virusA
                }
                if(type.at(posX.indexOf(j)) == 2){
                    img = virusB
                }
                if(type.at(posX.indexOf(j)) == 3){
                    img = virusC
                }
                if(type.at(posX.indexOf(j)) == 4){
                    img = antibodyA
                }
                if(type.at(posX.indexOf(j)) == 5){
                    img = antibodyB
                }
                if(type.at(posX.indexOf(j)) == 6){
                    img = antibodyC
                }
                setMap[i][j] = 
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
                    }} className="absolute top-1/2 left-1/2 transform -translate-x-1/2 -translate-y-1/2"/>
                    <img src={img} style={{
                    position: "relative",
                    width: `${maxScale-(maxScale/3)}px`,
                    height: `${maxScale-(maxScale/3)}px`,
                    margin: 0
                }} className="absolute -top-1/2 left-1/2 transform -translate-y-1/2 -translate-x-1/2"/>
                    <p className=" absolute bottom-0 left-1/2 transform -translate-x-1/2  font-Righteous" >
                        {Hp.at(posX.indexOf(j))}/{maxHp.at(posX.indexOf(j))}</p>                
                </div>
            }else{
                setMap[i][j] = <img src={slot} alt="" style={{
                    position: "relative",
                    width: `${maxScale}px`,
                    height: `${maxScale}px`,
                    margin: 0
    
                }} />
            }
                
        }
    }

    return(
        <div>
            {setMap.map((y: JSX.Element[]) => { return <tr>{y.map((x:JSX.Element) => {return <td>{x}</td>})} </tr>})}
            
        </div>
    )
}

export default Field