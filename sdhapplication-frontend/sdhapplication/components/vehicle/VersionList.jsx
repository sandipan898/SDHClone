import React from 'react'
import Version from './Version'
import VersionSearch from './VersionSearch';

const VersionList = ({ versions, family }) => {
  
  return (  
      <table class="bg-slate-800 w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
        <caption class="p-5 text-xl font-semibold text-left rtl:text-right bg-slate-800 dark:text-white dark:bg-gray-800">
          Versions
          <p class="mt-1 text-sm font-semibold dark:text-gray-300">Find all {family?.familyName} versions </p>
        </caption>
        <thead class="text-xs uppercase bg-gray-500 dark:bg-gray-700 dark:text-gray-100">
          <tr>
            <th scope="col" class="px-6 py-3">
              Version Code
            </th>
            <th scope="col" class="px-6 py-3">
              Version Name
            </th>
            <th scope="col" class="px-6 py-3">
              Family
            </th>
            <th scope="col" class="px-6 py-3">
              Car Type
            </th>
            <th scope="col" class="px-6 py-3">
              Action
            </th>
          </tr>
        </thead>
        <tbody>
          {versions?.map((version) => (
            <Version version={version} />
          ))}
        </tbody>
      </table>
  )
}

export default VersionList