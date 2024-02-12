import { handleResponse } from '@services/apiUtils';
import http from '@services/http-common';

export const getClients = () => http.get('/client/').then(handleResponse);

export const getClientById = (clientId) => http.get(`/client/${clientId}`).then(handleResponse);

export const getClientsByType = (type) => http.get(`/client/by_type/${type}`).then(handleResponse);

export const createClient = (clientData) => http.post('/client', clientData).then(handleResponse);

export const updateClient = (clientId, clientData) => http.put(`/client/${clientId}`, clientData).then(handleResponse);

export const deleteClient = (clientId) => http.delete(`/client/${clientId}`).then(handleResponse);
