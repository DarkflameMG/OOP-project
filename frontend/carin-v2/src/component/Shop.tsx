import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';
import '../style/style-maingame.css'
const Shop = () =>{
    return(
        <div className='shop flex flex-col'>
                    <p className="shop-text font-Righteous font-semibold">Shop</p>
                    <p className='antibody-text slot-shop antibody-set font-Righteous '>antibody A<button >
                        <img className='my-0.5' src={antibodyA} height={200} width={200} /></button>
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>antibody B<button >
                        <img className='my-0.5' src={antibodyB} height={200} width={200} /></button>
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>antibody C<button>
                        <img className='my-0.5' src={antibodyC} height={200} width={200} /></button>
                    </p>
                </div>
    )
}
export default Shop