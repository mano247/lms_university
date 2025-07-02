import { Univerzitet } from "./academic/univerzitet";

export interface Rektorat{
    id?: number; 
    naziv: string;
    kontakt: string;
    slika: string;
    adresa: string;
    univerziteti: Univerzitet[];
    ime_rektora: string;
}