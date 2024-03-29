import Image from 'next/image'
import Link from 'next/link'
import React from 'react'

const Nav = () => {
    return (
        <nav className="bg-dark border-gray-200 dark:bg-gray-900">
            <div className="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
                <Link href="/" className="flex items-center space-x-3 rtl:space-x-reverse">
                    <Image width={30} height={30} src="https://flowbite.com/docs/images/logo.svg" className="h-8" alt="Flowbite Logo" />
                    <span className="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">SDH</span>
                </Link>
                <button data-collapse-toggle="navbar-menu2" type="button" class="inline-flex items-center p-2 w-10 h-10 justify-center text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600" aria-controls="navbar-menu2" aria-expanded="false">
                    <span class="sr-only">Open main menu</span>
                    <svg class="w-5 h-5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 17 14">
                        <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 1h15M1 7h15M1 13h15" />
                    </svg>
                </button>
                <div className="w-full md:block md:w-auto" id="navbar-search">
                    <ul className="font-medium flex flex-row justify-center p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-dark md:flex-row md:space-x-8 rtl:space-x-reverse md:mt-0 md:border-0 md:bg-dark">
                        <li>
                            <Link href="/client/search" className="block py-2 px-3 text-white rounded md:hover:bg-transparent md:border-0 md:p-0">
                                <div class="relative mt-3">
                                    <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                                        <svg class="w-4 h-4 text-white-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                                        </svg>
                                    </div>
                                    <input type="button" id="search-navbar" class="block w-full p-2 ps-10 text-sm text-white border border-blue-900 rounded-lg bg-blue-700 focus:ring-blue-900 focus:border-blue-900 cursor-pointer" value="Client Search" />
                                </div>
                            </Link>
                        </li>
                        <li>
                            <Link href="/offer/search" className="block py-2 px-3 text-white rounded md:hover:bg-transparent md:border-0 md:p-0">
                                <div class="relative mt-3">
                                    <div class="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                                        <svg class="w-4 h-4 text-white-500" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                                        </svg>
                                    </div>
                                    <input type="button" id="search-navbar" class="block w-full p-2 ps-10 text-sm text-white border border-blue-900 rounded-lg bg-blue-700 focus:ring-blue-900 focus:border-blue-900 cursor-pointer" value="Offer Search" />
                                </div>
                            </Link>
                        </li>
                    </ul>
                </div>
                <div className="w-full md:block md:w-auto" id="navbar-menu2">
                    <ul className="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-dark md:flex-row md:space-x-8 rtl:space-x-reverse md:mt-0 md:border-0 md:bg-dark">
                        <li>
                            <Link href="#" className="block py-2 px-3 text-white rounded md:bg-transparent md:border-0 md:hover:text-blue-500 md:p-0" aria-current="page">Home</Link>
                        </li>
                        <li>
                            <Link href="#" className="block py-2 px-3 text-white rounded md:bg-transparent md:border-0 md:hover:text-blue-500 md:p-0">About</Link>
                        </li>
                        <li>
                            <button id="dropdownNavbarLink" data-dropdown-toggle="dropdownNavbar" class="flex items-center justify-between w-full py-2 px-3 text-white hover:bg-gray-900 md:hover:bg-transparent md:border-0 md:hover:text-blue-500 md:p-0 md:w-auto dark:text-white md:dark:hover:text-blue-500 dark:focus:text-white dark:hover:bg-gray-700 md:dark:hover:bg-transparent">Maintainance <svg class="w-2.5 h-2.5 ms-2.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                                <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4" />
                            </svg></button>
                            <div id="dropdownNavbar" class="z-10 hidden font-normal bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700 dark:divide-gray-600">
                                <ul class="py-2 rounded-md font-semibold text-sm dark:bg-slate-900 text-gray-100 dark:text-gray-200" aria-labelledby="dropdownLargeButton">
                                    <li>
                                        <Link href="/maintainance/auxiliarytable/" class="block px-4 py-2 hover:text-blue-500 dark:hover:bg-gray-800 dark:hover:text-blue-500">Auxiliary Data</Link>
                                    </li>
                                    <li aria-labelledby="dropdownNavbarLink">
                                        <button id="doubleDropdownButton" data-dropdown-toggle="doubleDropdown" data-dropdown-placement="right-start" type="button" class="flex items-center justify-between w-full px-4 py-2 hover:text-blue-500 dark:hover:bg-gray-800 dark:hover:text-blue-500">Dropdown<svg class="w-2.5 h-2.5 ms-2.5" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 10 6">
                                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="m1 1 4 4 4-4" />
                                        </svg></button>
                                        <div id="doubleDropdown" class="z-10 hidden bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700">
                                            <ul class="py-2 rounded-md font-semibold text-sm dark:bg-slate-900 text-gray-100 dark:text-gray-200" aria-labelledby="doubleDropdownButton">
                                                <li>
                                                    <a href="#" class="block px-4 py-2 hover:text-blue-500 dark:hover:bg-gray-800 dark:hover:text-blue-500">Overview</a>
                                                </li>
                                                <li>
                                                    <a href="#" class="block px-4 py-2 hover:text-blue-500 dark:hover:bg-gray-800 dark:hover:text-blue-500">My downloads</a>
                                                </li>
                                                <li>
                                                    <a href="#" class="block px-4 py-2 hover:text-blue-500 dark:hover:bg-gray-800 dark:hover:text-blue-500">Billing</a>
                                                </li>
                                                <li>
                                                    <a href="#" class="block px-4 py-2 hover:text-blue-500 dark:hover:bg-gray-800 dark:hover:text-blue-500">Rewards</a>
                                                </li>
                                            </ul>
                                        </div>
                                    </li>
                                    <li>
                                        <a href="#" class="block px-4 py-2 hover:text-blue-500 dark:hover:bg-gray-800 dark:hover:text-blue-500">Earnings</a>
                                    </li>
                                </ul>
                                {/* <div class="py-1">
                                    <a href="#" class="block px-4 py-2 text-sm text-gray-700 hover:bg-gray-100 dark:hover:bg-gray-600 dark:text-gray-200 dark:hover:text-white">Sign out</a>
                                </div> */}
                            </div>
                        </li>
                        <li>
                            <Link href="#" className="block py-2 px-3 text-white rounded md:bg-transparent md:border-0 md:hover:text-blue-500 md:p-0">Pricing</Link>
                        </li>
                        <li>
                            <Link href="#" className="block py-2 px-3 text-white rounded md:bg-transparent md:border-0 md:hover:text-blue-500 md:p-0">Contact</Link>
                        </li>
                    </ul>
                </div>
                <div className="w-full md:block md:w-auto" id="navbar-menu1">
                    <ul className="font-medium flex flex-row p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-dark md:flex-row md:space-x-8 rtl:space-x-reverse md:mt-0 md:border-0 md:bg-dark">
                        <li>
                            <Link href="#" className="block py-2 px-3 text-white rounded md:bg-transparent md:border-0 md:hover:text-blue-500 md:p-0">(nl | fr)</Link>
                        </li>
                        <li>
                            <Link href="#" className="block py-2 px-3 text-white rounded md:bg-transparent md:border-0 md:hover:text-blue-500 md:p-0">dealercode</Link>
                        </li>
                        <li>
                            <Link href="#" className="block py-2 px-3 text-white rounded md:bg-transparent md:border-0 md:hover:text-blue-500 md:p-0">logout</Link>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

    )
}

export default Nav