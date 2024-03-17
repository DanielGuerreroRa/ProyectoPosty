import { Component, EventEmitter, Output, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';
import { PublicacionesService } from '../_servicio/publicaciones.service'; 
import { Publicaciones } from '../_modelo/Publicaciones';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { PickerComponent } from '@ctrl/ngx-emoji-mart';
import {
  ionAddCircleOutline,
  ionChatboxEllipsesOutline,
  ionHappyOutline,
} from '@ng-icons/ionicons';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-busqueda',
  standalone: true,
  imports: [FormsModule, MatIconModule, NgIconComponent, PickerComponent, RouterModule],
  templateUrl: './busqueda.component.html',
  styleUrls: ['./busqueda.component.css'],
  viewProviders: [
    provideIcons({
      ionAddCircleOutline,
      ionHappyOutline,
      ionChatboxEllipsesOutline,
    }),
  ],
})

export class BusquedaComponent implements OnInit {
  publicaciones: Publicaciones[] = [];

  constructor(private publicacionesService: PublicacionesService) {}

  ngOnInit() {
    this.getPublicaciones();
  }

  getPublicaciones() {
    this.publicacionesService.getPublicaciones().subscribe(
      (data) => {
        this.publicaciones = data;
      },
      (error) => {
        console.error('Error obteniendo publicaciones', error);
      }
    );
  }
  
}