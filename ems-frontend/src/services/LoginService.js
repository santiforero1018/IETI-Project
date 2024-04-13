import axios from "axios";

const REST_API_BASE_URL = 'http://localhost:8080/v1/auth';

export const login = () => axios.get(REST_API_BASE_URL);