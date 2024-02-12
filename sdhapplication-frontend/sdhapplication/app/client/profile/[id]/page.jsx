"use client";

import ClientPage from '@components/client/ClientPage';
import { getClientById } from '@services/ClientServices';
import React, { useEffect, useState } from 'react'

const ClientProfilePage = ({ params }) => {
  const [client, setClient] = useState(null);

  const clientId = params.id;

  const fetchClient = async (clientId) => {
    const client = await getClientById(clientId);
    console.log("fetchClient", client);
    setClient(client);
  }

  useEffect(() => {
    fetchClient(clientId);
  }, [])

  return (
    <div class="p-4 bg-white md:p-4 dark:bg-gray-800">
      {client && (<ClientPage client = {client} />)}
    </div>

  )
}

export default ClientProfilePage