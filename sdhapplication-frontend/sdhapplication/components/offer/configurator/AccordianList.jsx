"use client";

import React from 'react'
import { Accordion } from 'flowbite-react';
import Personalization from '../personalization/Personalization';
import Discount from '../discount/Discount';
import Transformation from '../transformation/Transformation';

const AccordianList = ({ parameters, persData, handlePersOnChange }) => {
  console.log("AccordianList", parameters);

  const cmponentList = [{
    title: 'Personalization',
    content: <Personalization persData={persData} handlePersOnChange={handlePersOnChange} />,
    visible: parameters ? parameters['NRM_PERS']?.value === '1' : false
  }, {
    title: 'Transformation',
    content: <Transformation />,
    visible: true
  }, {
    title: 'Discount',
    content: <Discount />,
    visible: true
  }]

  return (
    <Accordion alwaysOpen>
      {cmponentList && cmponentList.map((component, key) => (
        component.visible ? (
            <Accordion.Panel key={key}>
              <Accordion.Title className='bg-gray-700 text-white hover:text-gray-900 hover:bg-gray-300 transition-all'>{component.title}</Accordion.Title>
              <Accordion.Content className='bg-gray-100'>
                {component.content}
              </Accordion.Content>
            </Accordion.Panel>
          ) : <></>
      ))}
    </Accordion>
  )
}

export default AccordianList