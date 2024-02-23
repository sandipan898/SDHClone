"use client";

import FamilyList from '@components/vehicle/FamilyList';
import { getFamilyByDealer } from '@services/VehicleServices';
import Link from 'next/link';
import React, { useEffect, useState } from 'react'

const FamilyPage = ({ params }) => {

    const [families, setFamilies] = useState([])
    const [filteredFamilies, setFilteredFamilies] = useState(families)
    const [familySearchTerm, setFamilySearchTerm] = useState("")
    const [searchTimeout, setSearchTimeout] = useState(null);

    const fetchFamilies = async () => {
        getFamilyByDealer("999999")
            .then(data => {
                console.log("fetchFamilies", data);
                setFamilies(data);
                setFilteredFamilies(data);
            })
            .catch(error => console.log(error))
    }

    useEffect(() => {
        fetchFamilies();
    }, [])

    const filterFamily = (searchTerm) => {
        const regex = new RegExp(searchTerm, "i");
        return families.filter(
            (family) =>
                regex.test(family.code) ||
                regex.test(family.familyName) ||
                regex.test(family.familyType)
        );
    }

    const handleFamilySearchChange = (e) => {
        clearTimeout(searchTimeout);
        setFamilySearchTerm(e.target.value);

        setSearchTimeout(
            setTimeout(() => {
                const filteredFamily = filterFamily(e.target.value);
                setFilteredFamilies(filteredFamily);
            }, 500)
        )
    }

    const clientId = localStorage?.getItem('clientId');

    return (
        <div className="md:m-5 sm:my-5">
            <h1 className="my-10 text-4xl text-center font-extrabold leading-none tracking-tight text-gray-900 md:text-4xl lg:text-5xl dark:text-white">{params?.type.toUpperCase()} Family</h1>
            <div className="md:w-4/5 mx-auto">
                <FamilyList clientId={clientId} familySearchTerm={familySearchTerm} params={params} families={filteredFamilies} handleFamilySearchChange={handleFamilySearchChange} />
            </div>
        </div>
    )
}

export default FamilyPage