import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';
import '../style/style-maingame.css'
const InvisibleShop = () =>{
    return(
        <div className='shop flex flex-col opacity-0'>
                    <p className="shop-text font-Righteous font-semibold">Shop</p>
                    <p className='antibody-text slot-shop antibody-set font-Righteous '>
                        <img className='my-0.5' src={antibodyA} height={200} width={200} />
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>
                        <img className='my-0.5' src={antibodyB} height={200} width={200} />
                    </p>

                    <p className='antibody-text slot-shop antibody-set font-Righteous'>
                        <img className='my-0.5' src={antibodyC} height={200} width={200} />
                    </p>
                </div>
    )
}
export default InvisibleShop