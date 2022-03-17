import { useState } from 'react';
import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';
import '../style/style-maingame.css'

let buyingUnit = ""
let numAntibody = 0

export const setBuyingUnit = (unit:string) =>{
    buyingUnit = unit
    // let numAntibody = 0
    console.log("Buy" + buyingUnit)
    if(unit=="AntibodyA"){
        numAntibody = 4
    }
    else if(unit=="AntibodyB"){
        numAntibody = 5
    }
    else if(unit=="AntibodyC"){
        numAntibody = 6
    }
    return numAntibody
}
// export {numAntibody}

export const getAntiboody = () => {
    return numAntibody
}

const Shop = ({costA,costB,costC}:any) =>{
    const [AntiA,setAntiA] = useState<String>("")

    return(
        <div className='shop flex flex-col'>
                    <p className="shop-text font-Righteous font-semibold">Shop</p>
                    <p className='antibody-text slot-shop antibody-set font-Righteous '>antibody A
                    <button ><img className='my-0.7' src={antibodyA} height={100} width={100} onClick = {()=>{setAntiA("AntibodyA"); setBuyingUnit("AntibodyA");}}/></button>
                        <p>{costA} $</p>
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>antibody B
                    <button ><img className='my-0.7' src={antibodyB} height={100} width={100} onClick = {()=>{setAntiA("AntibodyB"); setBuyingUnit("AntibodyB");}}/></button>
                        <p>{costB} $</p>
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>antibody C
                    <button><img className='my-0.7' src={antibodyC} height={100} width={100} onClick = {()=>{setAntiA("AntibodyC"); setBuyingUnit("AntibodyB");}}/></button>
                        <p>{costC} $</p>
                    </p>
                </div>
    )
}

export default Shop
