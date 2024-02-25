"use client";

import React from 'react'
import { Accordion } from 'flowbite-react';
import Personalization from '../personalization/Personalization';
import Discount from '../discount/Discount';
import Transformation from '../transformation/Transformation';

const AccordianList = () => {
  const cmponentList = [{
    title: 'Personalization',
    content: <Personalization />
  }, {
    title: 'Transformation',
    content: <Transformation />
  }, {
    title: 'Discount',
    content: <Discount />
  }]

  return (
    <Accordion alwaysOpen>
      {cmponentList && cmponentList.map((component, key) => (
        <Accordion.Panel key={key}>
        <Accordion.Title>{component.title}</Accordion.Title>
        <Accordion.Content>
          {component.content}
        </Accordion.Content>
      </Accordion.Panel>
      ))}

    </Accordion>
  )
}

export default AccordianList