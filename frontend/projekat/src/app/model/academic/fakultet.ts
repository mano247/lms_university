import { StudijskiProgram } from "./studijskiProgram";
import { Univerzitet } from "./univerzitet";

export interface Fakultet{
    id?: number;
    naziv: string;
    kontakt: string;
    tekstualniOpis: string;
    dekan: string;
    slika: string;
    adresa: string;
    nazivUniverziteta: string;
    sifraFakulteta: string;
    // univerzitet: Univerzitet;
    // studijskiProgrami: StudijskiProgram[];
}