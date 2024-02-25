import Link from 'next/link'
import React from 'react'

const Version = ({ version }) => {
  return (
    <tr class="bg-slate-800 border-b dark:bg-slate-800 dark:border-gray-700">
        <th scope="row" class="px-6 py-4 font-medium text-blue-600 whitespace-nowrap hover:underline">
           <Link href={`/offer/configurator/${version.code}`}>{version.code}</Link>
        </th>
        <td class="px-6 py-4 text-gray-200">
            {version.versionName}
        </td>
        <td class="px-6 py-4 text-gray-200">
        {version.family.code} - {version.family.familyName}
        </td>
        <td class="px-6 py-4 text-gray-200">
            {version.carType}
        </td>
        <td class="px-6 py-4 text-gray-200">
            <a href="#" class="font-medium text-blue-600 dark:text-blue-500 hover:underline">Edit</a>
        </td>
    </tr>
  )
}

export default Version