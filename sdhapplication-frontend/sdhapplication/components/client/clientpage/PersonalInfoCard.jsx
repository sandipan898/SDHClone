"use client";

import Link from 'next/link'
import React from 'react'

const PersonalInfoCard = ({client}) => {
  return (
    <div class="col-span-3 p-6 bg-white border border-gray-300 rounded-lg shadow">
        <h1 class="mb-4 pb-6 text-4xl text-center font-bold text-gray-900 md:text-4xl lg:text-3xl dark:text-white border-b border-gray-200">Personal Information</h1>
          <div class="relative overflow-x-auto">
            <table class="w-full text-lg text-left rtl:text-right text-gray-500 dark:text-gray-400">
              <tbody>
                <tr class="bg-white dark:bg-gray-800">
                  <th scope="row" class="text-gray-900 whitespace-nowrap dark:text-white">
                    Client ID
                  </th>
                  <td class="px-6 py-1">
                    {client.clientId}
                  </td>
                </tr>
                <tr class="bg-white dark:bg-gray-800">
                  <th scope="row" class="text-gray-900 whitespace-nowrap dark:text-white">
                    Clitne Type
                  </th>
                  <td class="px-6 py-1">
                    {client.type}
                  </td>
                </tr>
                <tr class="bg-white dark:bg-gray-800">
                  <th scope="row" class="text-gray-900 whitespace-nowrap dark:text-white">
                    First Name
                  </th>
                  <td class="px-6 py-1">
                    {client.firstName}
                  </td>
                </tr>
                <tr class="bg-white dark:bg-gray-800">
                  <th scope="row" class="text-gray-900 whitespace-nowrap dark:text-white">
                    Last Name
                  </th>
                  <td class="px-6 py-1">
                    {client.lastName}
                  </td>
                </tr>
                <tr class="bg-white dark:bg-gray-800">
                  <th scope="row" class="text-gray-900 whitespace-nowrap dark:text-white">
                    Email
                  </th>
                  <td class="px-6 py-1">
                    {client.email}
                  </td>
                </tr>
                <tr class="bg-white dark:bg-gray-800">
                  <th scope="row" class="text-gray-900 whitespace-nowrap dark:text-white">
                    Telephone
                  </th>
                  <td class="px-6 py-1">
                    {client.telephone}
                  </td>
                </tr>
                <tr class="bg-white dark:bg-gray-800">
                  <th scope="row" class="text-gray-900 whitespace-nowrap dark:text-white">
                    Address Line 1
                  </th>
                  <td class="px-6 py-1">
                    {client.address1}
                  </td>
                </tr>
                <tr class="bg-white dark:bg-gray-800">
                  <th scope="row" class="text-gray-900 whitespace-nowrap dark:text-white">
                    Address Line 2
                  </th>
                  <td class="px-6 py-1">
                    {client.address2}
                  </td>
                </tr>
              </tbody>
            </table>
          <Link href="#" class="inline-flex items-center mt-4 px-3 py-2 text-sm text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            Edit Client Details
            <svg class="rtl:rotate-180 w-3.5 h-3.5 ms-2" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9" />
            </svg>
          </Link>
          </div>
        </div>
  )
}

export default PersonalInfoCard