import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'

const API_BASE = 'http://localhost:8080';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(
    private http: HttpClient
  ) { }
  
  //el metodo getAll() es para llamar al api en el puerto 
  getAll(){
    return this.http.get(`${API_BASE}/animes`);
  }

  create(anime: any ){
    return this.http.post(`${API_BASE}/animes`, anime);
  }

  update(id: string, anime: any){
    return this.http.put(`${API_BASE}/animes/${id}`,anime);
  }
  delete(id: string){
    return this.http.delete(`${API_BASE}/animes/${id}`);

  }


}
