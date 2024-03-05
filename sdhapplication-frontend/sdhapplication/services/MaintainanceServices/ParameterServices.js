import { handleResponse } from '@services/apiUtils';
import http from '@services/http-common';

export const getParameters = () => http.get('/parameter/').then(handleResponse);

export const getParameterById = (id) => http.get(`/parameter/${id}`).then(handleResponse);

export const getParameterByKey = (key) => http.get(`/parameter/by_key/${key}`).then(handleResponse);

export const getParameterValueByKey = (key) => http.get(`/parameter/value_by_key/${key}`).then(handleResponse);

export const createParameter = (parameterData) => http.post('/parameter', parameterData).then(handleResponse);

export const updateParameter = (id, parameterData) => http.put(`/parameter/${id}`, parameterData).then(handleResponse);

export const deleteParameter = (id) => http.delete(`/parameter/${id}`).then(handleResponse);
