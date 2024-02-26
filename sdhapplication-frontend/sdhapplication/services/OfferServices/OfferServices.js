import { handleResponse } from '@services/apiUtils';
import http from '@services/http-common';

export const getOffers = () => http.get('/offer/').then(handleResponse);

export const getOfferById = (id) => http.get(`/offer/${id}`).then(handleResponse);

export const getOffersByDealer = (code) => http.get(`/offer/by_dealer/${code}`).then(handleResponse);

export const getOffersByClient = (clientId) => http.get(`/offer/by_client/${clientId}`).then(handleResponse);

export const getOffersByUser = (userId) => http.get(`/offer/by_user/${userId}`).then(handleResponse);

export const createOffer = (offerData) => http.post('/offer', offerData).then(handleResponse);

export const updateOffer = (id, offerData) => http.put(`/offer/${id}`, offerData).then(handleResponse);

export const deleteOffer = (id) => http.delete(`/offer/${id}`).then(handleResponse);
