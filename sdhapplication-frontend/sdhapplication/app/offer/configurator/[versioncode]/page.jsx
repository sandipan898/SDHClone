"use client";

import Configurator from '@components/offer/configurator/Configurator';
import ConfirmationModal from '@components/offer/configurator/ConfirmationModal';
import { getVersionByCode } from '@services/VehicleServices/VersionServices';
import { Router } from 'next/router';
import React, { useEffect, useState } from 'react'

const ConfiguratorPage = ({ params }) => {
    const versioncode = params.versioncode;
    const [clientId, setClientId] = useState(null);

    const [version, setVersion] = useState({})

    const fetchVersion = async () => {
        getVersionByCode(versioncode)
            .then(data => {
                console.log("fetchVersion", data);
                setVersion(data);
            })
            .catch(error => console.log(error))
    }

    useEffect(() => {
        fetchVersion();
        const clientId = localStorage?.getItem('clientId');
        setClientId(clientId);
    }, [])

    return (
        <div className='md:m-5 sm:my-5'>
            <div className="border border-gray-200 rounded-lg shadow">
                {clientId ? <Configurator version={version} /> : <ConfirmationModal /> }
            </div>
        </div>
    )
}

export default ConfiguratorPage