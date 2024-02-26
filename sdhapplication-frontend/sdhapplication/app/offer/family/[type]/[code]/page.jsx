"use client";

import VersionList from '@components/vehicle/version/VersionList';
import VersionSearch from '@components/vehicle/version/VersionSearch';
import { getVersionByFamilyCode } from '@services/VehicleServices/VersionServices';
import Link from 'next/link';
import React, { useEffect, useState } from 'react'

const VersionPage = ({ params }) => {
  const familyCode = params?.code;
  const [versions, setVersions] = useState([])
  const [filteredVersions, setFilteredVersions] = useState(versions)
  const [versionSearchTerm, setVersionSearchTerm] = useState("")
  const [searchTimeout, setSearchTimeout] = useState(null);

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

  const filterVersions = (searchTerm) => {
    const regex = new RegExp(searchTerm, "i");
    return versions.filter(
      (versions) =>
        regex.test(versions.code) ||
        regex.test(versions.versionName)
    );
  }

  const handleVersionSearchChange = (e) => {
    clearTimeout(searchTimeout);
    setVersionSearchTerm(e.target.value);

    setSearchTimeout(
      setTimeout(() => {
        const filteredVersions = filterVersions(e.target.value);
        setFilteredVersions(filteredVersions);
      }, 500))
  }

  const family = versions && versions.length && versions[0].family;

  return (
    <div className="md:m-5 sm:my-5">
      <h1 className="my-10 text-4xl text-center font-extrabold leading-none tracking-tight text-gray-900 md:text-4xl lg:text-5xl dark:text-white">{family.familyName} - {params?.code?.toUpperCase()} Versions</h1>
      <div className="md:w-4/5 mx-auto">
        <div class="relative overflow-x-auto border border-gray-200 rounded-lg shadow sm:rounded-lg p-4">

          <Link href={`/offer/family/${params?.type}`} class="inline-flex w-100 items-center mt-4 px-3 py-2 text-sm text-center text-white bg-blue-700 rounded-lg hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
            <svg class="w-6 h-6 text-white dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24">
              <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 12h14M5 12l4-4m-4 4 4 4" />
            </svg>
            {params?.type.toUpperCase()} Family
          </Link>
          <VersionSearch handleVersionSearchChange={handleVersionSearchChange} versionSearchTerm={versionSearchTerm} />
          <VersionList params={params} versions={filteredVersions} family={family} />
        </div>
      </div>
    </div>
  )
}

export default VersionPage