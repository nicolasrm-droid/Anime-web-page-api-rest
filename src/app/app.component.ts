import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  animes: any[] = [];
  anime = {
    id: null,
    nombre: '',
    partes: '',
    lugar: '',
    demonio: '',


  }



  constructor(
    private appService: AppService
  ) {

  }

  ngOnInit(): void {
    this.getAll();

  }

  getAll() {
    this.appService.getAll()
      .subscribe((data: any) => this.animes = data);

  }

  save() {
    
    if (this.anime.id) {
 
      this.appService.update(this.anime.id!, this.anime)
        .subscribe(() => this.getAll());

    } else {
      this.appService.create(this.anime)
        .subscribe(data => this.getAll());

    }
    this.anime = {

      id: null,
      nombre: '',
      partes: '',
      lugar: '',
      demonio: '',

    }

  }
  edit(anime: any) {
    
    this.anime = {
      
      ...anime
    }
  
  }
  delete(anime: any) {
    this.appService.delete(anime.id)
      .subscribe(() => this.getAll());

  }







}
