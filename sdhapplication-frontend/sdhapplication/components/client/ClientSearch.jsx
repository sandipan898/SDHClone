"use client"

const ClientSearch = ({
    handleSearchSubmit, searchClicked, handleClearSearch, clientSearchTerm, handleClientSearchChange, handleClientTypeChange,
    handleClientIdChange, clientId
}) => {
    return (
        <div className="md:m-5 sm:my-5">
            <h1 className="my-10 text-4xl text-center font-extrabold leading-none tracking-tight text-gray-900 md:text-4xl lg:text-5xl dark:text-white">Search Client</h1>
            <form className="md:w-4/5 mx-auto" onSubmit={handleSearchSubmit}>
                <div className="border border-gray-200 rounded-lg shadow">
                    <div className='md:flex md:flex-row md:justify-center p-4 mt-4 sm:flex-col'>
                        <div className="md:mx-5 w-full">
                            <div className="flex">
                                <label htmlFor="clientSearch" className="block w-1/5 mt-2 text-sm font-medium text-gray-900 dark:text-white">Search</label>
                                <span className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-e-0 border-gray-300 rounded-s-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
                                    <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
                                        <path stroke="currentColor" stroke-linecap="round" stroke-width="2" d="m21 21-3.5-3.5M17 10a7 7 0 1 1-14 0 7 7 0 0 1 14 0Z" />
                                    </svg>
                                </span>
                                <input disabled={!searchClicked} value={clientSearchTerm} onChange={(e) => handleClientSearchChange(e)} id="clientSearch" className={`border w-4/5 xs:w-full border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500  ${!searchClicked ? 'bg-gray-50' : 'bg-white'}`} />
                            </div>
                        </div>
                    </div>
                    <div className="md:flex md:flex-row md:justify-center p-4 mb-4 sm:flex-col">
                        <div className="md:mx-5 w-full">
                            <div className="flex ">
                                <label htmlFor="clientType" className="block w-2/5 mt-2 text-sm font-medium text-gray-900 dark:text-white">Select Client Type</label>
                                <select id="clientType" onChange={handleClientTypeChange} className="bg-white border w-3/5 xs:w-full border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500">
                                    <option>-- Select Type</option>
                                    <option>B2C</option>
                                    <option>B2B</option>
                                </select>
                            </div>
                        </div>

                        <div className="md:mx-5 w-full">
                            <div className="flex ">
                                <label htmlFor="clientId" className="block w-2/5 mt-2 text-sm font-medium text-gray-900 dark:text-white">Client Id</label>
                                <span className="inline-flex items-center px-3 text-sm text-gray-900 bg-gray-200 border border-e-0 border-gray-300 rounded-s-md dark:bg-gray-600 dark:text-gray-400 dark:border-gray-600">
                                    <svg class="w-6 h-6 text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="currentColor" viewBox="0 0 24 24">
                                        <path fill-rule="evenodd" d="M12 4a4 4 0 1 0 0 8 4 4 0 0 0 0-8Zm-2 9a4 4 0 0 0-4 4v1c0 1.1.9 2 2 2h8a2 2 0 0 0 2-2v-1a4 4 0 0 0-4-4h-4Z" clip-rule="evenodd" />
                                    </svg>
                                </span>
                                <input value={clientId} onChange={handleClientIdChange} id="clientId" className="bg-white border w-3/5 xs:w-full border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block p-2.5 dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500" />
                            </div>
                        </div>
                    </div>
                </div>
                <div className="flex justify-center my-8">
                    <button type="submit" className="inline-flex items-center justify-center mx-5 px-5 py-3 text-base font-medium text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 dark:focus:ring-blue-900">
                        Get Clients
                        <svg className="w-3.5 h-3.5 ms-2 rtl:rotate-180" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 14 10">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M1 5h12m0 0L9 1m4 4L9 9" />
                        </svg>
                    </button>
                    {searchClicked &&
                        <button onClick={handleClearSearch} className="inline-flex items-center justify-center mx-5 px-5 py-3 text-base font-medium text-center text-white bg-red-700 rounded-lg hover:bg-red-800 focus:ring-4 focus:ring-red-300 dark:focus:ring-blue-900">
                            <svg class="h-6 w-6 mr-2 text-white" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">  <path d="M21 4H8l-7 8 7 8h13a2 2 0 0 0 2-2V6a2 2 0 0 0-2-2z" />  <line x1="18" y1="9" x2="12" y2="15" />  <line x1="12" y1="9" x2="18" y2="15" /></svg>
                            Clear Search
                        </button>}
                </div>
            </form>
        </div>
    )
}

export default ClientSearch