import Link from 'next/link'
import React from 'react'
import PersonalInfoCard from './PersonalInfoCard'
import ClientActionsCard from './ClientActionsCard'

const ClientPage = ({ client }) => {
  return (
    <div class="grid max-w-screen-xl grid-cols-1 gap-4 mx-auto sm:grid-cols-3 xl:grid-cols-6 sm:p-8">
        <PersonalInfoCard client={client} />
        <ClientActionsCard />
      </div>
  )
}

export default ClientPage