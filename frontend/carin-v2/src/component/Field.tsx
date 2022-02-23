import { TransformComponent, TransformWrapper } from "react-zoom-pan-pinch"

const Field = () => {
    return (
        <div>
            <TransformWrapper>
                <TransformComponent>
                    <div className='container'>
                        <div className='item'>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-virus'></div>
                        </div>
                        <div className='item'>

                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                        </div>
                        <div className='item'>

                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-virus'></div>
                        </div>
                        <div className='item'>

                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                        </div>
                        <div className='item'>

                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-virus'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                            <div className='slot-antibody'></div>
                        </div>
                        <div className='item'>

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
        </div>

    )
}

export default Field