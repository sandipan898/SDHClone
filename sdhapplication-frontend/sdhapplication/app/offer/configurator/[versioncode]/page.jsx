"use client";

import Configurator from '@components/offer/configurator/Configurator';
import ConfirmationModal from '@components/offer/configurator/ConfirmationModal';
import { getParameterByKey } from '@services/MaintainanceServices/ParameterServices';
import { createOffer } from '@services/OfferServices/OfferServices';
import { getVersionByCode } from '@services/VehicleServices/VersionServices';
import React, { useEffect, useState } from 'react'

const ConfiguratorPage = ({ params }) => {
    const parameterKeys = ['NRM_PERS'];
    const versioncode = params.versioncode;
    const [clientId, setClientId] = useState(null);
    const [parameters, setParameters] = useState({});
    const [persData, setPersData] = useState(null)
    const [totalPrice, setTotalPrice] = useState(0);
    const [version, setVersion] = useState({})
    const [optionData, setOptionData] = useState({})
    const [optionPrice, setOptionPrice] = useState({})

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

    const handlePersOnChange = (e) => {
        setPersData(persData => ({
            ...persData, [e.target.name]: e.target.value
        }))
        if (e.target.name?.toLowerCase().includes('price') && e.target.value && e.target.value > 0) {
            setTotalPrice(totalPrice => totalPrice + parseInt(e.target.value))
        }
    }

    const handleColorTrimOptionChange = (e) => {
        console.log('handleColorTrimOptionChange: ', optionData);
        let data = e.target.value?.split('-');
        let code = data?.length > 0 && data[0];
        let price = data?.length > 0 && data[data.length - 1]
        const regex = new RegExp(code, "i");

        const codePresent = regex.test(optionData.option) ||
                regex.test(optionData.color) ||
                regex.test(optionData.trim)

        if (e.target.name?.includes('option')) {
            if (optionData.option && optionPrice.option) {
                code = code + "|" + optionData.option;
                price = parseFloat(price) + optionPrice.option
            }
        }
        
        if (codePresent) {
            price = optionPrice.option;
            code = code;
        } else {
            setTotalPrice(totalPrice => totalPrice + parseFloat(price))
        }

        setOptionData(optionData => ({
            ...optionData, [e.target.name]: code
        }))

        setOptionPrice(optionPrice => ({
            ...optionPrice, [e.target.name + "Price"]: parseFloat(price)
        }))
    }

    const handleSaveOffer = async () => {
        const offerData = {
            offerID: " ",
            user: {
                id: localStorage.getItem('userId') ? localStorage.getItem('userId') : '0c941cdb-3d3d-40d7-b622-f8168d908dd5'
            },
            cre: {
                codCre: localStorage.getItem('codCre') ? localStorage.getItem('codCre') : '999999'
            },
            car: {
                code: versioncode,
            },
            client: {
                clientId: localStorage.getItem('clientId')
            },
            ...optionData,
            ...optionPrice,
            totalPrice
        }

        console.log("handleSaveOffer", offerData);

        await createOffer(offerData)
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
                {clientId ?
                    <Configurator version={version} parameters={parameters} persData={persData} handlePersOnChange={handlePersOnChange}
                        handleSaveOffer={handleSaveOffer} totalPrice={totalPrice} handleColorTrimOptionChange={handleColorTrimOptionChange}
                        optionData={optionData} optionPrice={optionPrice}
                    /> : <ConfirmationModal />}
            </div>
        </div>
    )
}

export default ConfiguratorPage