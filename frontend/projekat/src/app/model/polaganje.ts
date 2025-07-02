import { Predmet } from "./academic/predmet";
import { Obavestenje } from "./obavestenje";
import { Nastavnik } from "./users/nastavnik";
import { Student } from "./users/student";

export interface Polaganje{
    id?: number; 
    bodovi?: number; 
    konacnaOcena?: number; 
    pocetak?: Date; 
    kraj?: Date; 
    napomena?: string; 
    predmet?: Predmet; 
    student?: Student; 
    obavestenje?: Obavestenje; 
    nastavnik?: Nastavnik;
}