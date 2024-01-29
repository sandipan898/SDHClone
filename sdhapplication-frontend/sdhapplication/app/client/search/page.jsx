"use client"

import ClientSearch from "@components/client/ClientSearch";
import ClientTable from "@components/client/ClientTable";
import { useState } from "react";

const ClientSearchPage = () => {
    const [searchClicked, setsearchClicked] = useState(false);
    const handleSearchSubmit = (e) => {
      e.preventDefault();
      setsearchClicked(true);
    }

    const handleClearSearch = (e) => {
      setsearchClicked(false);
    }

  return (
    <div className="mx-10">
        <ClientSearch handleSearchSubmit={handleSearchSubmit} searchClicked={searchClicked} handleClearSearch={handleClearSearch} />
        {
            searchClicked && <ClientTable />
        }
    </div>
  )
}

export default ClientSearchPage