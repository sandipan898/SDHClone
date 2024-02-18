"use client";

import VersionList from '@components/vehicle/VersionList';
import VersionSearch from '@components/vehicle/VersionSearch';
import { getVersionByFamilyCode } from '@services/VehicleServices';
import React, { useEffect, useState } from 'react'

const VersionPage = ({ params }) => {
  const familyCode = params?.code;
  const [versions, setVersions] = useState([])
  const [filteredVersions, setFilteredVersions] = useState(versions)
  const [versionSearchTerm, setVersionSearchTerm] = useState(versions)

  const fetchVersions = async () => {
    getVersionByFamilyCode(familyCode)
      .then(data => {
        console.log("fetchVersions", data);
        setVersions(data);
        setFilteredVersions(data);
      })
      .catch(error => console.log(error))
  }

  useEffect(() => {
    fetchVersions();
  }, [])

  useEffect(() => {
    handleVersionSearchChange()
  }, [versionSearchTerm])
  

  const handleVersionSearchChange = () => {
    if(versionSearchTerm === "") {
      setFilteredVersions(versions)
    } else {
      let regex = new RegExp(/^[a-zA-Z]+$/);

      const filteredVersions = versions.filter(version => regex.test(versionSearchTerm))
      setFilteredVersions(filteredVersions);
    }
  }

  const family = versions && versions.length && versions[0].family;

  return (
    <div className="md:m-5 sm:my-5">
      <h1 className="my-10 text-4xl text-center font-extrabold leading-none tracking-tight text-gray-900 md:text-4xl lg:text-5xl dark:text-white">{family.familyName} - {params?.code?.toUpperCase()} Versions</h1>
      <div className="md:w-4/5 mx-auto">
        <div class="relative overflow-x-auto border border-gray-200 rounded-lg shadow sm:rounded-lg p-4">
          <VersionSearch setVersionSearchTerm={setVersionSearchTerm} />
          <VersionList params={params} versions={filteredVersions} handleVersionSearchChange={handleVersionSearchChange} family={family} />
        </div>
      </div>
    </div>
  )
}

export default VersionPage