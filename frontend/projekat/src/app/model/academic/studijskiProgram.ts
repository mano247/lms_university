import { GodinaStudija } from "../godinaStudija";
import { Fakultet } from "./fakultet";
import { Predmet } from "./predmet";

export interface StudijskiProgram{
    id?: number; 
    opis: string;
    naziv: string;
    rukovodilac: string;
    godineStudija: GodinaStudija[]; 
    // fakultet: Fakultet; 
    fakultet: Fakultet;
    predmeti: Predmet[];
    sifraSP: string;
}