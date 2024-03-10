import React from 'react'
import Accordians from './AccordianList'
import AccordianList from './AccordianList'
import PriceBox from './PriceBox';
import PriceBoxes from './PriceBoxes';

const Configurator = ({ version, parameters, persData, handlePersOnChange }) => {
    console.log("Configurator", parameters);
    return (
        <div className='border-b border-gray-200'>
            <div className='md:flex md:flex-row md:justify-center p-4 sm:flex-col'>
                <div className="md:mx-5 w-full">
                    <div className="flex my-4">
                        <label htmlFor="familyType" className="block w-1/5 mt-2 text-sm font-medium text-gray-900 dark:text-white">Color</label>
                        <select id="familyType" className="bg-gray-50 border w-4/5 xs:w-full border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                            <option>-- Select Color</option>
                            {version?.colorList?.map((color, key) => (
                                <option key={key} value={color}>{color}</option>
                            ))}
                        </select>
                    </div>
                </div>

                <div className="md:mx-5 w-full">
                    <div className="flex my-4">
                        <label htmlFor="familyCode" className="block w-1/5 mt-2 text-sm font-medium text-gray-900 dark:text-white">Trim</label>
                        <select id="familyCode" className="bg-gray-50 border w-4/5 xs:w-full border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                            <option>-- Select Family</option>
                            {version?.trimList?.map((trim, key) => (
                                <option key={key} value={trim}>{trim}</option>
                            ))}
                        </select>
                    </div>
                </div>
            </div>
            <div className='p-4 md:mx-5'>
                <h3 class="mb-4 font-semibold text-gray-900 dark:text-white">Options</h3>
                <ul class="w-full text-sm font-medium text-gray-900 bg-white border border-gray-200 rounded-lg dark:bg-gray-700 dark:border-gray-600 dark:text-white">
                    {version?.optionList?.map((option, key) => (
                        <li key={key} class="w-full border-b border-gray-200 rounded-t-lg dark:border-gray-600">
                            <div class="flex items-center ps-3">
                                <input id={option + key} type="checkbox" value={option} class="w-4 h-4 text-blue-600 bg-gray-100 border-gray-300 rounded focus:ring-blue-500 dark:focus:ring-blue-600 dark:ring-offset-gray-700 dark:focus:ring-offset-gray-700 focus:ring-2 dark:bg-gray-600 dark:border-gray-500" />
                                <label for={option + key} class="w-full py-3 ms-2 text-sm font-medium text-gray-900 dark:text-gray-300">{option}</label>
                            </div>
                        </li>
                    ))}
                </ul>
            </div>

            <AccordianList parameters={parameters} persData={persData} handlePersOnChange={handlePersOnChange} />
            <PriceBoxes persData={persData} handlePersOnChange={handlePersOnChange} />
        </div>
    )
}

export default Configurator