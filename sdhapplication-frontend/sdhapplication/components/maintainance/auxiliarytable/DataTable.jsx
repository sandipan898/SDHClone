import { Button } from 'flowbite-react';
import Link from 'next/link';
import React from 'react'
import EditDataModal from './EditDataModal';

const DataTable = ({ tableData, tableName, handleDataUpdate, openModal, setOpenModal, handleEditOnChange, editTableData, setEditTableData }) => {
    const tableCols = tableData && tableData.length > 0 &&
        Object.keys(tableData[0])
            .filter(tColName => !(tableData[0][tColName] instanceof Object || tColName?.toLowerCase().includes('id') || tColName?.toLowerCase().includes('creationdate')));
    console.log("DataTable", tableData, openModal, tableCols);

    return (
        <table class="bg-slate-800 w-full text-sm text-left rtl:text-right text-gray-500 dark:text-gray-400">
            <caption class="p-5 text-xl font-semibold text-left rtl:text-right bg-slate-800 dark:text-white dark:bg-gray-800">
                Table - {tableName?.toUpperCase()}
                <p class="mt-1 text-sm font-semibold dark:text-gray-300">Auxiliary Table Management </p>
            </caption>
            <thead class="text-xs uppercase bg-gray-500 dark:bg-gray-700 dark:text-gray-100">
                <tr>
                    {tableCols && tableCols.map(tColName => <th scope="col" class="px-6 py-3">{tColName}</th>
                    )}
                </tr>
            </thead>
            <tbody>
                {
                    tableData && tableData.length > 0 && tableData.map(tData => 
                            tableCols && tableCols.map((tColName, key) => {
                                if (key === 0) return (
                                    <th scope="row" onClick={() => { setOpenModal(true); setEditTableData(tData) }} class="px-6 py-4 font-medium text-blue-600 whitespace-nowrap hover:cursor-pointer">
                                        {tData[tColName]}
                                    </th>
                                )
                                else
                                    return <td scope="col" class="px-6 py-4 text-gray-200">{tData[tColName]}</td>
                            })
                    )
                }
            </tbody>
            <EditDataModal
                openModal={openModal} setOpenModal={setOpenModal} handleDataUpdate={handleDataUpdate} tableCols={tableCols}
                tableData={tableData} editTableData={editTableData} handleEditOnChange={handleEditOnChange}
            />
        </table>
    )
}

export default DataTable