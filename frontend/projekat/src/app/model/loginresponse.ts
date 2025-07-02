export interface LoginResponse {
    token: string;
    id?: number;
    email: string;
    roles: string[];
}