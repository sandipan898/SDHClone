import React from 'react'
import PriceBox from './PriceBox'

const PriceBoxes = ({ persData, optionData, optionPrice, totalPrice }) => {
  console.log("PriceBoxes: ", persData, optionData, optionPrice, totalPrice);
  return (
    <div className='md:flex xs:flex-row mx-auto items-center justify-center bg-white my-10 px-5'>
        {persData && persData.persPrice && totalPrice > 0 && <><PriceBox title={"Personalization"} price={persData?.persPrice} /> <span className='mx-2'>+</span></>}
        {optionPrice && Object.keys(optionPrice).map(optionKey => (
          <><PriceBox title={optionKey} price={optionPrice[optionKey]} /> <span className='mx-2'>+</span></>
        ))}
        {/* <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>+</span>
        <PriceBox title={"personalization"} price={"300"} /> <span className='mx-2'>=</span> */}
        {totalPrice > 0 && <><span className='mx-2'>=</span><PriceBox title={"Total Price"} price={totalPrice} /></>}
    </div>
  )
}

export default PriceBoxes