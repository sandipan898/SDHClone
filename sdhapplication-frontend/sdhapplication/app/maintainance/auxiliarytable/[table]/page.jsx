"use client";

import DataTable from '@components/maintainance/auxiliarytable/DataTable';
import { getParameters } from '@services/MaintainanceServices/ParameterServices';
import { useState, useEffect } from 'react';

const TablePage = ({ params }) => {
  const tableName = params.table;
  const [tableData, setTableData] = useState({})

  const fetchTableData = async (tableName) => {
    if (tableName === "par") {
      try {
        const tableData = await getParameters();
        setTableData(tableData);
      } catch (e) {
        console.log("Error", e);
      }
    }
  }

  useEffect(() => {
    fetchTableData(tableName)
  }, [])

  return (
    <div>
      <DataTable tableData={tableData} />
    </div>
  )
}

export default TablePage

