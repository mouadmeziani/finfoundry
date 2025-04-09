import axios from 'axios';

export const api = axios.create({
  baseURL: 'http://localhost:8080/api',
  timeout: 10000,
});

export const getTransactionsByUser = async (userId: string) => {
  const response = await api.get(`/transactions/user/${userId}`);
  return response.data;
};