import { Nastavnik } from "./users/nastavnik";
import { Student } from "./users/student";

export interface ZavrsniRad{
    id?: number;
    tema: string;
    link: string;
    student: Student;
    profesor: Nastavnik;
}