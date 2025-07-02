import { Rektorat } from "../rektorat";
import { Nastavnik } from "../users/nastavnik";
import { Fakultet } from "./fakultet";

export interface Univerzitet{
    id?: number;
    naziv: string;
    datumOsnivanja: Date;
    opis: string;
    kontakt: string;
    slika: string;
    adresa: string;
    rektorat: Rektorat;
}