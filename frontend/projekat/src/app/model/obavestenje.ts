import { Predmet } from "./academic/predmet";
import { Nastavnik } from "./users/nastavnik";

export interface Obavestenje{
    id?: number; 
    datum: Date; 
    sadrzaj: string; 
    naslov: string;
    slika: string;
    vremePocetka: Date; 
    vremeKraja: Date; 
    predmet?: Predmet;
}