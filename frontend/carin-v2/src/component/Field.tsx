import axios from "axios";
import { Component, useEffect, useState } from "react";
import { TransformComponent, TransformWrapper } from "react-zoom-pan-pinch"
import { resourceLimits } from "worker_threads";
import square from '../image/square.png';

export type dataType = {
    x : number,
    y : number,
    costAntibodyA : number,
    costAntibodyB : number,
    costAntibodyC : number,
}

const Field = ({X,Y}:any) => {

    let m = 10
    let n = 10

    if(X != undefined && Y != undefined){
        m = X
        n = Y
    }
    let maxScale = 100

    let winWidth = window.innerWidth * 0.8
    let winHeight = window.innerHeight * 0.4
    let x_scale: number = winWidth / m
    let y_scale: number = winWidth / n
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
    let setMap: JSX.Element[][] = new Array(n)


    for (let i = 0; i < n; i++) {
        setMap[i] = new Array(m)
        for (let j = 0; j < m; j++) {
            setMap[i][j] = <img src={square} alt="" style={{
                position: "relative",
                width: `${maxScale}px`,
                height: `${maxScale}px`,
                margin: 0

            }} />
        }
    }

    return(
        <div>
            {setMap.map((y: JSX.Element[]) => { return <tr>{y.map((x:JSX.Element) => {return <td>{x}</td>})} </tr>})}
        </div>
    )
}

export default Field