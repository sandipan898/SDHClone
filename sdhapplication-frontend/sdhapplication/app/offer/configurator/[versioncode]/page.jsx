"use client";

import Configurator from '@components/offer/configurator/Configurator';
import ConfirmationModal from '@components/offer/configurator/ConfirmationModal';
import { getParameterByKey } from '@services/MaintainanceServices/ParameterServices';
import { getVersionByCode } from '@services/VehicleServices/VersionServices';
import React, { useEffect, useState } from 'react'

const ConfiguratorPage = ({ params }) => {
    const parameterKeys = ['NRM_PERS'];
    const versioncode = params.versioncode;
    const [clientId, setClientId] = useState(null);
    const [parameters, setParameters] = useState({});

    const [version, setVersion] = useState({})

    const fetchVersion = async () => {
        getVersionByCode(versioncode)
            .then(data => {
                console.log("fetchVersion", data);
                setVersion(data);
            })
            .catch(error => console.log(error))
    }

    const fetchParameters = async () => {
        parameterKeys.forEach(async (parKey) => {
            getParameterByKey(parKey)
                .then((par) => {
                    console.log("par", par);
                    setParameters((parameters => ({
                        ...parameters, [parKey]: par
                    })))
                }
                ).catch(e => {
                    console.log("Error- > fetchParameters: ", e);
                })
        })
        console.log("fetchParameters:", parameters);
    }

    useEffect(() => {
        fetchVersion();
        const clientId = localStorage?.getItem('clientId');
        setClientId(clientId);
        fetchParameters();
    }, [])



    return (
        <div className='md:m-5 sm:my-5'>
            <div className="border border-gray-200 rounded-lg shadow">
                {clientId ? <Configurator version={version} parameters={parameters} /> : <ConfirmationModal />}
            </div>
        </div>
    )
}

export default ConfiguratorPage