import { handleResponse } from '@services/apiUtils';
import http from '@services/http-common';

export const getFamilies = () => http.get('/family/').then(handleResponse);

export const getFamilyByCode = (familyCode) => http.get(`/family/${familyCode}`).then(handleResponse);

export const getFamilyByDealer = (dealerId) => http.get(`/family/by_dealer/${dealerId}`).then(handleResponse);

export const getFamilyByUser = (userId) => http.get(`/family/by_user/${userId}`).then(handleResponse);

export const createFamily = (familyData) => http.post('/family', familyData).then(handleResponse);

export const updateFamily = (familyCode, familyData) => http.put(`/family/${familyCode}`, familyData).then(handleResponse);

export const deleteFamily = (familyCode) => http.delete(`/family/${familyCode}`).then(handleResponse);


export const getVersions = () => http.get('/version/').then(handleResponse);

export const getVersionByCode = (versionCode) => http.get(`/version/${versionCode}`).then(handleResponse);

export const getVersionByFamilyCode = (familyCode) => http.get(`/version/by_family/${familyCode}`).then(handleResponse);

export const createVersion = (versionData) => http.post('/version', versionData).then(handleResponse);

export const updateVersion = (versionCode, versionData) => http.put(`/version/${versionCode}`, versionData).then(handleResponse);

export const deleteVersion = (versionCode) => http.delete(`/version/${versionCode}`).then(handleResponse);
