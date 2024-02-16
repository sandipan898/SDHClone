import { handleResponse } from '@services/apiUtils';
import http from '@services/http-common';

export const getFamilies = () => http.get('/family/').then(handleResponse);

export const getFamilyByCode = (familyCode) => http.get(`/family/${familyCode}`).then(handleResponse);

export const getFamilyByDealer = (dealerId) => http.get(`/family/by_dealer/${dealerId}`).then(handleResponse);

export const getFamilyByUser = (userId) => http.get(`/family/by_user/${userId}`).then(handleResponse);

export const createFamily = (familyData) => http.post('/family', familyData).then(handleResponse);

export const updateFamily = (familyCode, familyData) => http.put(`/family/${familyCode}`, familyData).then(handleResponse);

export const deleteFamily = (familyCode) => http.delete(`/family/${familyCode}`).then(handleResponse);
