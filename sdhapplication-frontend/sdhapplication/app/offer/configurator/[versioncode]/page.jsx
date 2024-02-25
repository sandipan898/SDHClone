"use client";

import Configurator from '@components/offer/configurator/Configurator';
import { getVersionByCode } from '@services/VehicleServices';
import React, { useEffect, useState } from 'react'

const ConfiguratorPage = ({ params }) => {
    const versioncode = params.versioncode;

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
    }, [])

    return (
        <div className='md:m-5 sm:my-5'>
            <div className="border border-gray-200 rounded-lg shadow">
                <Configurator version={version} />
            </div>
        </div>
    )
}

export default ConfiguratorPage