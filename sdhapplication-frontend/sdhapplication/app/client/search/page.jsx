"use client"

import ClientSearch from "@components/client/ClientSearch";
import ClientTable from "@components/client/ClientTable";
import { useEffect, useState } from "react";
import { getClients } from "@services/ClientServices";

const ClientSearchPage = () => {
    const [searchClicked, setsearchClicked] = useState(false);
    const [clients, setClients] = useState([]);
    const [filteredClients, setFilteredClients] = useState(clients);

    const handleSearchSubmit = (e) => {
      e.preventDefault();
      setsearchClicked(true);
    }

    const handleClearSearch = (e) => {
      setsearchClicked(false);
      setFilteredClients(clients);
    }

    const fetchClients = async () => {
      const clients = await getClients();
      console.log("fetchClients", clients);
      setClients(clients);
      setFilteredClients(clients)
    }

    useEffect(() => {
      fetchClients();
    }, [])

  return (
    <div className="mx-10">
        <ClientSearch filteredClients={filteredClients} handleSearchSubmit={handleSearchSubmit} searchClicked={searchClicked} handleClearSearch={handleClearSearch} />
        {
            searchClicked && <ClientTable clients={filteredClients} />
        }
    </div>
  )
}

export default ClientSearchPage