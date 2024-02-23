import React from 'react'

const VersionSearch = ({ handleVersionSearchChange, versionSearchTerm }) => {
    return (
        <div className='md:flex md:flex-row md:justify-center p-4 sm:flex-col border-b border-gray-200'>
            <div className="md:mx-5 w-full">
                <div className="flex my-4">
                    <label htmlFor="versionSearch" className="block w-1/5 mt-2 text-sm font-medium text-gray-900 dark:text-white">Search</label>
                    <span className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-e-0 border-gray-300 rounded-s-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
                        <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
                            <path stroke="currentColor" stroke-linecap="round" stroke-width="2" d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z" />
                        </svg>
                    </span>
                    <input value={versionSearchTerm} onChange={(e) => handleVersionSearchChange(e)} id="versionSearch" className="bg-white border w-4/5 xs:w-full border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" />
                </div>
            </div>
        </div>
    )
}

export default VersionSearch