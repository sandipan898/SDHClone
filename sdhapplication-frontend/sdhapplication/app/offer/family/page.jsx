"use client";

import { getFamilies, getFamilyByDealer } from '@services/VehicleServices';
import React, { useEffect, useState } from 'react'

const FamilyPage = () => {

  const [families, setFamilies] = useState([])

  const fetchFamilies = async () => {
    getFamilyByDealer("999999")
      .then(data => {
        console.log("fetchFamilies", data);
        setFamilies(data);
      })
      .catch(error => console.log(error))
  }

  useEffect(() => {
    fetchFamilies();
  }, [])

  return (
    <div>FamilyPage</div>
  )
}

export default FamilyPage