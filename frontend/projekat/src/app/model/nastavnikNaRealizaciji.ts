import { TipNastave } from "./tipNastave";

export interface NastavnikNaRealizaciji{
    id?: number; 
    brojCasova: number; 
    nastavnik_id: number; 
    tip_nastave: TipNastave;
}