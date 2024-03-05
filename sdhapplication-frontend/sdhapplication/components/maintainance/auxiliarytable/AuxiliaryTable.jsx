import Link from 'next/link'
import React from 'react'

const AuxiliaryTable = ({ tables }) => {
  return (
    <table class="bg-slate-800 w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
      <caption class="p-5 text-xl font-semibold text-left rtl:text-right bg-slate-800 dark:text-white dark:bg-gray-800">
        Versions
        <p class="mt-1 text-sm font-semibold dark:text-gray-300">Auxiliary Table Management </p>
      </caption>
      <thead class="text-xs uppercase bg-gray-500 dark:bg-gray-700 dark:text-gray-100">
        <tr>
          <th scope="col" class="px-6 py-3">
            Table Name
          </th>
          <th scope="col" class="px-6 py-3">
            Table Description
          </th>
        </tr>
      </thead>
      <tbody>
        {tables && tables.length > 0 && tables.map(table => (
          <tr class="bg-slate-800 border-b dark:bg-slate-800 dark:border-gray-700">
            <th scope="row" class="px-6 py-4 font-medium text-blue-600 whitespace-nowrap hover:underline">
              <Link href={`/maintainance/auxiliarytable/${table.linkname}`}>{table.name}</Link>
            </th>
            <td class="px-6 py-4 text-gray-200">
              {table.description}
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  )
}

export default AuxiliaryTable