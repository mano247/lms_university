import { Permission } from "../permission";

export interface RegistrovaniKorisnik{
    id?: number;
    korisnickoIme: string;
    lozinka: string;
    email: string;
    ime: string;
    prezime: string;
    permissions: Permission[];
}