import { Predmet } from "../academic/predmet";
import { GodinaStudija } from "../godinaStudija";
import { Polaganje } from "../polaganje";
import { RegistrovaniKorisnik } from "./registrovaniKorisnik";

export interface Student extends RegistrovaniKorisnik{
    brojIndeksa: string;
    godinaStudija: GodinaStudija[]; 
    polaganja: Polaganje[]; 
    predmet: Predmet[]; // ispraviti sa predmet na predmeti
}