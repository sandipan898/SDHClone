import React from 'react'

const DataTable = ({ tableData }) => {
    console.log("DataTable", tableData);
    return (
        <table class="bg-slate-800 w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
            <caption class="p-5 text-xl font-semibold text-left rtl:text-right bg-slate-800 dark:text-white dark:bg-gray-800">
                Versions
                <p class="mt-1 text-sm font-semibold dark:text-gray-300">Auxiliary Table Management </p>
            </caption>
            <thead class="text-xs uppercase bg-gray-500 dark:bg-gray-700 dark:text-gray-100">
                <tr>
                    {tableData && tableData.length > 0 && Object.keys(tableData[0]).map(tColName => (
                        <th scope="col" class="px-6 py-3">{tColName}</th>
                    ))}
                </tr>
            </thead>
            <tbody>
                {tableData && tableData.length > 0 && Object.keys(tableData[0]).map(tColName => (
                    <th scope="col" class="px-6 py-3">{tColName}</th>
                ))}
            </tbody>
        </table>
    )
}

export default DataTable