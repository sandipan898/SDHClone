import React from 'react'
import Family from './Family'
import Link from 'next/link'

const FamilyList = ({ clientId, params, families, handleFamilySearchChange, familySearchTerm }) => {
  return (
    <div className="border border-gray-200 rounded-lg shadow">
        <Link href={`/client/profile/${clientId}`} class="mx-4 inline-flex w-100 items-center mt-4 px-3 py-2 text-sm text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            <svg class="w-6 h-6 text-white dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 12h14M5 12l4-4m-4 4 4 4"/>
            </svg>
            Client Page
        </Link>
      <div className='md:flex md:flex-row md:justify-center p-4 sm:flex-col border-b border-gray-200'>
        <div className="md:mx-5 w-full">
          <div className="flex my-4">
            <label htmlFor="clientId" className="block w-2/5 mt-2 text-sm font-medium text-gray-900 dark:text-white">Search</label>
            <span className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-e-0 border-gray-300 rounded-s-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
            <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
              <path stroke="currentColor" stroke-linecap="round" stroke-width="2" d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z"/>
            </svg>
            </span>
            <input value={familySearchTerm} onChange={(e) => handleFamilySearchChange(e)} id="familySearch" className="bg-white border w-3/5 xs:w-full border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" />
          </div>
        </div>

        <div className="md:mx-5 w-full">
          <div className="flex my-4">
            <label htmlFor="familyType" className="block w-2/5 mt-2 text-sm font-medium text-gray-900 dark:text-white">Select Car Type</label>
            <select id="familyType" className="bg-gray-50 border w-3/5 xs:w-full border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
              <option>-- Select Type</option>
              <option>VP</option>
              <option>VU</option>
            </select>
          </div>
        </div>

        <div className="md:mx-5 w-full">
          <div className="flex my-4">
            <label htmlFor="familyCode" className="block w-2/5 mt-2 text-sm font-medium text-gray-900 dark:text-white">Select Family</label>
            <select id="familyCode" className="bg-gray-50 border w-3/5 xs:w-full border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
              <option>-- Select Family</option>
              {families?.map((family, key) => (
                <option key={key} value={family.code}>{family.code}</option>
              ))}
            </select>
          </div>
        </div>
      </div>
      <div className='p-4 grid grid-cols-1 md:grid-cols-4 gap-2'>
            {families?.map((family, key) => (
              <Family type={params?.type} key={key} family={family} />
            ))}
      </div>
    </div>
  )
}

export default FamilyList