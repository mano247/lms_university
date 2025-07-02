import { Ishod } from "../ishod";
import { Predmet } from "./predmet";

export interface NastavniMaterijal{
    id?: number; 
    naslov: string; 
    autori: string; 
    godinaIzdavanja: string; 
    izdavac: string; 
    brojStrana: number; 
    opis: string; 
    url: string; 
    ishod: string; 
    izdato: number; 
    kolicina: number;
}