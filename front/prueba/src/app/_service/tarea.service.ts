import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Subject } from 'rxjs';
import { Tarea } from '../_model/Tarea';

@Injectable({
  providedIn: 'root'
})
export class TareaService {
  private url = `http://localhost:8080/tasks`;
  mensajeCambio = new Subject<string>();

  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any>(`${this.url}`);
  }
  
  guardar(tarea: Tarea){
    return this.http.post(`${this.url}`, tarea);
  }

  eliminar(id:any){
    return this.http.delete<any>(`${this.url}/${id}`);
  }
}
