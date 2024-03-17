"use client";

import Link from "next/link";

const Footer = ({ handleSaveOffer }) => {
    return (
        <footer className="text-right p-4 md:mx-1">
            <Link href="/client/search" className="mx-1 md:hover:bg-transparent md:border-0 md:p-0">
                <input type="button" id="search-navbar" class="w-32 text-sm py-2 px-3 text-white border border-gray-600 rounded bg-gray-500 focus:ring-gray-900 focus:border-gray-900 cursor-pointer" value="Back" />
            </Link>
            <button className="w-32 text-sm py-2 px-3 text-white border border-blue-900 rounded bg-blue-700 focus:ring-blue-900 focus:border-blue-900 cursor-pointer" onClick={handleSaveOffer}>Save Offer</button>
        </footer>
    )
}

export default Footer