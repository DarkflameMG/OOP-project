import axios from "axios";
import { Component, useEffect, useState } from "react";
import { TransformComponent, TransformWrapper } from "react-zoom-pan-pinch"
import { resourceLimits } from "worker_threads";
import square from '../image/square.png';

const apiField = 'http://localhost:8080/api/field' 


export type dataType = {
    x : number,
    y : number,
    costAntibodyA : number,
    costAntibodyB : number,
    costAntibodyC : number,
}

// const Field = ({X,Y}:any) => {

//     let m = 10
//     let n = 10

//     if(X != undefined && Y != undefined){
//         m = X
//         n = Y

const Field = () => {
    
    const [data,setData] = useState<dataType>();
    const [x, setX] = useState<number>();
    const [y, setY] = useState<number>();
    const [costAntibodyA, setCostAntibodyA] = useState<number>();
    const [costAntibodyB, setCostAntibodyB] = useState<number>();
    const [costAntibodyC, setCostAntibodyC] = useState<number>();

    const fetch = async() =>{
        try{
            const resp = await axios.get<dataType>(apiField)
            setData(resp.data)
            console.log(resp.data)
            console.groupCollapsed(data)
            console.log("fielddddddd")
        }
        catch(err){
            console.log(err) 
        }
    }

    useEffect(()=>{
        fetch()
        console.log(data)
        if(data != null){
            console.log("setFieldd")
            setX(data.x)
            setY(data.y)
            setCostAntibodyA(data.costAntibodyA)
            setCostAntibodyB(data.costAntibodyB)
            setCostAntibodyC(data.costAntibodyC)
            console.log(data)
            console.log("x:" + x)
            console.log("y:" + y)
            console.log("costAntibodyA:" + costAntibodyA)
            console.log("costAntibodyB:" + costAntibodyB)
            console.log("costAntibodyC:" + costAntibodyC)
        }
    },[])

    let m = 30
    let n = 10
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

    return setMap.map((y: JSX.Element[]) => { return <tr>{y.map((x:JSX.Element) => {return <td>{x}</td>})} </tr>})

    // return(
    //     <div>
    //         {setMap.map((y: JSX.Element[]) => { return <tr>{y.map((x:JSX.Element) => {return <td>{x}</td>})} </tr>})}
    //     </div>
    // )

}

export default Field