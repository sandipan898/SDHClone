import React from 'react'

const PriceBox = ({ title, price }) => {
    console.log("PriceBox", title, price);
    return (
        <div className="w-48 h-24 border border-gray-300 rounded-lg shadow sm:rounded-lg">
            <div class="bg-slate-300 border-gray-400 border-b text-center py-2 font-bold">{title}</div>
            <div className='text-center py-2 text-xl'>${price}</div>
        </div>
    )
}

export default PriceBox