import { TransformComponent, TransformWrapper } from "react-zoom-pan-pinch"
import square from '../image/square.png';

const Field = () => {
    const m = 10
    const n = 10
    let maxScale = 5
    
    let winWidth = window.innerWidth * 0.2
    let winHeight = window.innerHeight * 0.4
    let x_scale: number = winWidth / m
    let y_scale: number = winWidth / n*2
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
}

export default Field