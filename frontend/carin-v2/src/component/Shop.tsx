import antibodyA from '../image/antibodyA.png';
import antibodyB from '../image/antibodyB.png';
import antibodyC from '../image/antibodyC.png';
const Shop = () =>{
    return(
        <div className='shop flex flex-col'>
                    <p className="shop-text font-Righteous font-semibold">Shop</p>
                    <p><button className='antibody-set font-Righteous'>antibody A
                        <img src={antibodyA} height={200} width={200} /></button>
                    </p>

                    <p><button className='antibody-set font-Righteous'>antibody B
                        <img src={antibodyB} height={200} width={200} /></button>
                    </p>

                    <p><button className='antibody-set font-Righteous'>antibody C
                        <img src={antibodyC} height={200} width={200} /></button>
                    </p>
                </div>
    )
}
export default Shop