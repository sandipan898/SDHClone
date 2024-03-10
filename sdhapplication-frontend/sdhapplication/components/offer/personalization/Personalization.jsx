"use client";

import { Button } from 'flowbite-react';
import React from 'react'

const Personalization = ({ persData, handlePersOnChange }) => {
    return (
        <div className="md:m-5 sm:my-5">
            <div className="md:w-full mx-auto bg-white">
                <form class="relative overflow-x-auto border border-gray-300 rounded-lg shadow sm:rounded-lg p-4">
                    <div className='md:flex md:flex-row md:justify-center p-4 sm:flex-col'>
                        <div className="md:mx-5 w-full">
                            <div className="md:flex my-2">
                                <label for="persDescription" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Personalization Description</label>
                                <input type="text" name="persDescription" id="persDescription" class='bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500' value={persData?.desciption} placeholder={`Enter Description here`} onChange={handlePersOnChange} />
                            </div>
                        </div>

                        <div className="md:mx-5 w-full">
                            <div className="md:flex my-2">
                                <label for="persPrice" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Personalization Price</label>
                                <input type="text" name="persPrice" id="persPrice" class='bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500' value={persData?.price} placeholder={`Enter Price here`} onChange={handlePersOnChange} />
                            </div>
                        </div>
                    </div>
                    <div className='md:flex md:flex-row md:justify-center p-4 sm:flex-col'>
                        <div className="md:mx-5 md:w-2/5 xs:w-full">
                            <div className="md:flex">
                                <label for="persLeadtime" class="block mb-2 text-sm font-medium text-gray-900 dark:text-white">Personalization Leadtime</label>
                                <input type="text" name="persLeadtime" id="persLeadtime" class='bg-white border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-primary-600 focus:border-primary-600 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 dark:text-white dark:focus:ring-primary-500 dark:focus:border-primary-500' value={persData?.leadtime} placeholder={`Leadtime will appear here`} />
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div >
    )
}

export default Personalization