import AuxiliaryTable from '@components/maintainance/auxiliarytable/AuxiliaryTable'
import Link from 'next/link'
import React from 'react'

const AuxiliaryPage = () => {
  const tables = [{
    name: "PAR (Parameter)",
    description: "Manage Parameter Data",
    linkname: "par"
  }]
  return (
    <div className="md:m-5 sm:my-5">
      <h1 className="my-10 text-4xl text-center font-extrabold leading-none tracking-tight text-gray-900 md:text-4xl lg:text-5xl dark:text-white">Auxiliary Data Management</h1>
      <div className="md:w-4/5 mx-auto">
        <div class="relative overflow-x-auto border border-gray-200 rounded-lg shadow sm:rounded-lg p-4">
          <Link href={`/`} class="inline-flex w-100 items-center my-4 px-3 py-2 text-sm text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            <svg class="w-6 h-6 text-white dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 12h14M5 12l4-4m-4 4 4 4" />
            </svg>
            Back
          </Link>
          <AuxiliaryTable tables={tables} />
        </div>
      </div>
    </div>
  )
}

export default AuxiliaryPage