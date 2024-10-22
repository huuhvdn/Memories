
import axios, { AxiosError, AxiosResponse } from 'axios';

const httpClient = axios.create({
    baseURL: 'http://localhost:8000/api',
    headers: {
        "Content-Type": "application/json",
    },
})

httpClient.interceptors.request.use((config) => {
    const token = "Memories"
    if (token) {
        config.headers.Authorization = `Bearer ${token}`;
    }
    return config;
}, (error) => {
    console.log("Error instance", error);
})

httpClient.interceptors.response.use((response: AxiosResponse) => {
    return response;
}, (error: AxiosError) => {
    return Promise.reject(error);
});

export interface ApiResponse<T> {
    data: T | null;
    status: number;
    message?: string;
    error?: any
}

export interface HttpService {
    get<T>(url: string): Promise<ApiResponse<T>>;
    post<T>(url: string, payload: T): Promise<ApiResponse<T>>;
}

const httpService: HttpService = {
    async get<T>(url: string): Promise<ApiResponse<T>> {
        try {
            const response = await httpClient.get<T>(url);
            return {
                data: response.data,
                status: response.status
            }
        } catch (error) {
            if (axios.isAxiosError(error)) {
                return {
                    data: null,
                    status: error.response?.status || 500
                }
            }
            throw error;
        }
    },
    async post<T>(url: string, payload: T): Promise<ApiResponse<T>> {
        try {
            const response = await httpClient.post<T>(url, payload);
            return {
                data: response.data,
                status: response.status
            }
        } catch (error) {
            if (axios.isAxiosError(error)) {
                return {
                    data: null,
                    status: error.response?.status || 500
                }
            }
            throw error;
        }
    }
}

export default httpService;