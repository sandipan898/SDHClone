import { handleResponse } from '@services/apiUtils';
import http from '@services/http-common';

export const getVersions = () => http.get('/version/').then(handleResponse);

export const getVersionByCode = (versionCode) => http.get(`/version/${versionCode}`).then(handleResponse);

export const getVersionByFamilyCode = (familyCode) => http.get(`/version/by_family/${familyCode}`).then(handleResponse);

export const createVersion = (versionData) => http.post('/version', versionData).then(handleResponse);

export const updateVersion = (versionCode, versionData) => http.put(`/version/${versionCode}`, versionData).then(handleResponse);

export const deleteVersion = (versionCode) => http.delete(`/version/${versionCode}`).then(handleResponse);
