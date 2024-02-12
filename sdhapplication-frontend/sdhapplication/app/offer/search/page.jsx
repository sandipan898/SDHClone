"use client";

import OfferSearch from '@components/offer/OfferSearch'
import OfferTable from '@components/offer/OfferTable';
import { useState } from 'react';

const OfferSearchPage = () => {
  const [searchClicked, setsearchClicked] = useState(false);
    const handleSearchSubmit = (e) => {
      e.preventDefault();
      setsearchClicked(true);
    }

    const handleClearSearch = (e) => {
      setsearchClicked(false);
    }
    
  return (
    <div className="mx-10">
      <OfferSearch handleSearchSubmit={handleSearchSubmit} searchClicked={searchClicked} handleClearSearch={handleClearSearch} />
      {
            searchClicked && <OfferTable />
      }
    </div>
  )
}

export default OfferSearchPage