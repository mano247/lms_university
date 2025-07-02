import { Predmet } from "../academic/predmet";
import { Univerzitet } from "../academic/univerzitet";
import { Polaganje } from "../polaganje";
import { RegistrovaniKorisnik } from "./registrovaniKorisnik";

export interface Nastavnik extends RegistrovaniKorisnik{
    biografija: string;
    jmbg: string;
    univerzitet: Univerzitet; 
    predmeti: Predmet[]; 
    polaganja: Polaganje[];
}