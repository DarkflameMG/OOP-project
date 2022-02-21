import { TransformComponent, TransformWrapper } from "react-zoom-pan-pinch"

const Field = () =>{
    return(
        <TransformWrapper>
                    <TransformComponent>
                        <div className='field'>
                        <div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-virus'></div>
                        </div>
                        <div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                        </div>
                        <div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-virus'></div>
                        </div>
                        <div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                        </div>
                        <div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                        </div>
                        <div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                        </div>
                        </div>
                    </TransformComponent>
                </TransformWrapper>
    )
}

export default Field