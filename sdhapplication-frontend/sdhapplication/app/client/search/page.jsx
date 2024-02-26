"use client"

import ClientSearch from "@components/client/ClientSearch";
import ClientTable from "@components/client/ClientTable";
import { useEffect, useState } from "react";
import { getClients } from "@services/ClientServices";

const ClientSearchPage = () => {
  const [searchClicked, setsearchClicked] = useState(false);
  const [clients, setClients] = useState([]);
  const [filteredClients, setFilteredClients] = useState(clients);
  const [clientSearchTerm, setClientSearchTerm] = useState("");
  const [clientId, setClientId] = useState(null)

  const handleSearchSubmit = (e) => {
    e.preventDefault();
    setsearchClicked(true);
  }

  const handleClearSearch = (e) => {
    setsearchClicked(false);
    setFilteredClients(clients);
  }

  const filterClients = (searchTerm) => {
    const regex = new RegExp(searchTerm, "i");
    return clients.filter(
      (client) => 
        regex.test(client.address1) ||
        regex.test(client.address2) ||
        regex.test(client.email) ||
        regex.test(client.firstName) ||
        regex.test(client.lastName)
    );
  }

  const handleClientSearchChange = (e) => {
    // clearTimeout(searchTimeout);
    setClientSearchTerm(e.target.value);

    // setSearchTimeout(
      // setTimeout(() => {
    const filteredClients = filterClients(e.target.value);
    setFilteredClients(filteredClients);
      // }, 500))
  }

  const handleClientTypeChange = (e) => {
    let filteredClients = [];
    if (e.target.value === "B2B" || e.target.value === "B2C") {
      filteredClients = clients.filter(cli => cli.type == e.target.value)
    } else {
      filteredClients = clients;
    }
    setFilteredClients(filteredClients);
  }

  const handleClientIdChange = (e) => {
    setClientId(e.target.value)
    let filteredClients = [];
    if (e.target.value !== "") {
      filteredClients = clients.filter(cli => cli.clientId == e.target.value)
    } else {
      filteredClients = clients;
    }
    setFilteredClients(filteredClients);
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
      <ClientSearch
        filteredClients={filteredClients} handleSearchSubmit={handleSearchSubmit} searchClicked={searchClicked}
        handleClearSearch={handleClearSearch} clientSearchTerm={clientSearchTerm} handleClientSearchChange={handleClientSearchChange}
        handleClientTypeChange={handleClientTypeChange} handleClientIdChange={handleClientIdChange} clientId={clientId}
      />
      {
        searchClicked && <ClientTable clients={filteredClients} />
      }
    </div>
  )
}

export default ClientSearchPage