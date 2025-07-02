import { StudijskiProgram } from "./academic/studijskiProgram";
import { Student } from "./users/student";

export interface GodinaStudija{
    id?: number; 
    godina: number; 
    studijskiProgram: StudijskiProgram; 
    studenti: Student[];
}