"use client"

import ClientSearch from "@components/client/ClientSearch";
import ClientTable from "@components/client/ClientTable";
import { useEffect, useState } from "react";
import { getClients } from "@services/ClientServices";

const ClientSearchPage = () => {
    const [searchClicked, setsearchClicked] = useState(false);
    const [clients, setClients] = useState([]);

    const handleSearchSubmit = (e) => {
      e.preventDefault();
      setsearchClicked(true);
    }

    const handleClearSearch = (e) => {
      setsearchClicked(false);
    }

    const fetchClients = async () => {
      const clients = await getClients();
      console.log("fetchClients", clients);
      setClients(clients);
    }

    useEffect(() => {
      fetchClients();
    }, [])

  return (
    <div className="mx-10">
        <ClientSearch handleSearchSubmit={handleSearchSubmit} searchClicked={searchClicked} handleClearSearch={handleClearSearch} />
        {
            searchClicked && <ClientTable clients={clients} />
        }
    </div>
  )
}

export default ClientSearchPage