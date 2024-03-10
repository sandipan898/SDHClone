import React from 'react'
import PriceBox from './PriceBox'

const PriceBoxes = ({ persData, handlePersOnChange }) => {
  return (
    <div className='md:flex xs:flex-row mx-auto items-center justify-around bg-white my-10 px-5'>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>=</span>
        <PriceBox title={"personalization"} price={"300"} />
    </div>
  )
}

export default PriceBoxes