import { handleResponse } from '@services/apiUtils';
import http from '@services/http-common';

export const getPersonalizarions = () => http.get('/personalization/').then(handleResponse);

export const getPersonalizarionById = (id) => http.get(`/personalization/${id}`).then(handleResponse);

export const getPersonalizarionByRange = (minPrice, maxPrice) => http.get(`/personalization/by_range?maxPrice=${minPrice}&maxPrice=${maxPrice}`).then(handleResponse);

export const getPersonalizarionByPrice = (price) => http.get(`/personalization/by_price?price=${price}`).then(handleResponse);

export const createPersonalizarion = (personalizationData) => http.post('/personalization', personalizationData).then(handleResponse);

export const updatePersonalizarion = (id, personalizationData) => http.put(`/personalization/${id}`, personalizationData).then(handleResponse);

export const deletePersonalizarion = (id) => http.delete(`/personalization/${id}`).then(handleResponse);
