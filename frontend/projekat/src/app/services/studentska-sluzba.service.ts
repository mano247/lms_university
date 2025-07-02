import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StudentskaSluzba } from '../model/users/studentskaSluzba';
import { NastavniMaterijal } from '../model/academic/nastavniMaterijal';

@Injectable({
  providedIn: 'root'
})
export class StudentskaSluzbaService {

  constructor(private http: HttpClient) { }

  getAll(){
    return this.http.get<StudentskaSluzba[]>("http://localhost:8080/api/studentskaSluzba");
  }

  getById(id: number){
    return this.http.get<StudentskaSluzba>(`http://localhost:8080/api/studentskaSluzba/${id}`);
  }

  delete(id: number){
    return this.http.delete<StudentskaSluzba>(`http://localhost:8080/api/studentskaSluzba/${id}`);
  }

  update(id: number, studentskaSluzba: StudentskaSluzba){
    return this.http.put<StudentskaSluzba>(`http://localhost:8080/api/studentskaSluzba/${id}`, studentskaSluzba);
  }

  create(studentskaSluzba: StudentskaSluzba){
    return this.http.post<StudentskaSluzba>("http://localhost:8080/api/studentskaSluzba", studentskaSluzba);
  }

  getKorisnici(){
    return this.http.get<any[]>("http://localhost:8080/api/registrovaniKorisnici");
  }

  getUdzbenici(){
    return this.http.get<NastavniMaterijal[]>("http://localhost:8080/api/nastavnimaterijal");
  }

  upisiNaGodinu(sng: any){
    return this.http.post<any>("http://localhost:8080//api/sng", sng)
  }

}
