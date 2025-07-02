import { Obavestenje } from "../obavestenje";
import { Polaganje } from "../polaganje";
import { Nastavnik } from "../users/nastavnik";
import { Student } from "../users/student";
import { NastavniMaterijal } from "./nastavniMaterijal";
import { StudijskiProgram } from "./studijskiProgram";

export interface Predmet{
    id?: number; 
    silabus: string; 
    naziv: string; 
    espb: number; 
    vremePocetka: Date; 
    vremeKraja: Date; 
    opis: string; 
    nastavniMaterijal: NastavniMaterijal[]; 
    polaganje: Polaganje[]; 
    nastavnik?: Nastavnik; 
    studenti: Student[]; 
    obavestenja: Obavestenje[]; 
    smer: any; 
    sifraPredmeta: string;
    
}