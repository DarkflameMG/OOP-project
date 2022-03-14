import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';
import '../style/style-maingame.css'
const Shop = ({costA,costB,costC}:any) =>{
    return(
        <div className='shop flex flex-col'>
                    <p className="shop-text font-Righteous font-semibold">Shop</p>
                    <p className='antibody-text slot-shop antibody-set font-Righteous '>antibody A
                    <button ><img className='my-0.7' src={antibodyA} height={100} width={100} /></button>
                        <p>{costA} $</p>
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>antibody B
                    <button ><img className='my-0.7' src={antibodyB} height={100} width={100} /></button>
                        <p>{costB} $</p>
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>antibody C
                    <button><img className='my-0.7' src={antibodyC} height={100} width={100} /></button>
                        <p>{costC} $</p>
                    </p>
                </div>
    )
}
export default Shop