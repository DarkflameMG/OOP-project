import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';
import '../style/style-maingame.css'
const Shop = () =>{
    return(
        <div className='shop flex flex-col'>
                    <p className="shop-text font-Righteous font-semibold">Shop</p>
                    <p className='antibody-text slot-shop antibody-set font-Righteous '>antibody A
                    <button ><img className='my-0.7' src={antibodyA} height={100} width={100} /></button>
                        <p>10000</p>
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>antibody B
                    <button ><img className='my-0.7' src={antibodyB} height={100} width={100} /></button>
                        <p>10000</p>
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>antibody C
                    <button><img className='my-0.7' src={antibodyC} height={100} width={100} /></button>
                        <p>10000</p>
                    </p>
                </div>
    )
}
export default Shop