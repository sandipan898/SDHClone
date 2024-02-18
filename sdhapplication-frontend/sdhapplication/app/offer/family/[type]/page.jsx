"use client";

import FamilyList from '@components/vehicle/FamilyList';
import { getFamilyByDealer } from '@services/VehicleServices';
import React, { useEffect, useState } from 'react'

const FamilyPage = ({ params }) => {

    const [families, setFamilies] = useState([])
    const [filteredFamilies, setFilteredFamilies] = useState(families)
    const [familySearchTerm, setFamilySearchTerm] = useState(families)
    
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

    useEffect(() => {
        handleFamilySearchChange();
    }, [familySearchTerm])
    

    const handleFamilySearchChange = () => {        
        if(familySearchTerm === "") {
            setFilteredFamilies(families)
        } else {
            let regex = new RegExp(/^[a-zA-Z]+$/);
 
            const filteredFamilies = families.filter(family => regex.test(familySearchTerm))
            setFilteredFamilies(filteredFamilies);
        }
    }

    return (
        <div className="md:m-5 sm:my-5">
            <h1 className="my-10 text-4xl text-center font-extrabold leading-none tracking-tight text-gray-900 md:text-4xl lg:text-5xl dark:text-white">{params?.type.toUpperCase()} Family</h1>
            <div className="md:w-4/5 mx-auto">
                <FamilyList params={params} families={filteredFamilies} setFamilySearchTerm={setFamilySearchTerm} />
            </div>
        </div>
    )
}

export default FamilyPage