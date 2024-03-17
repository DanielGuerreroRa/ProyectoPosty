import { AsyncPipe, CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatIconModule } from '@angular/material/icon';
import { RouterModule } from '@angular/router';
import { PublicacionesService } from '../_servicio/publicaciones.service';
import { PublicarComentarioService } from '../_servicio/publicar-comentario.service';
import { Publicaciones } from '../_modelo/Publicaciones';
import { Comentarios } from '../_modelo/Comentarios';
import { FormsModule } from '@angular/forms';
import { NgIconComponent, provideIcons } from '@ng-icons/core';

import {
  ionHeartCircleOutline,
  ionChatboxEllipsesOutline,
  ionShareOutline,
  ionBookmarkOutline,
} from '@ng-icons/ionicons';
import { PublicacionModalComponent } from '../publicacion-modal/publicacion-modal.component';
import { UsuarioService } from '../_servicio/usuario.service';
import { Usuario } from '../_modelo/Usuario';
import { HistoriaModalComponent } from '../historia-modal/historia-modal.component';
import { ComentarioPost } from '../_modelo/ComentarioPost';

@Component({
  selector: 'app-inicio',
  standalone: true,
  imports: [
    RouterModule,
    MatIconModule,
    CommonModule,
    AsyncPipe,
    FormsModule,
    NgIconComponent,
    PublicacionModalComponent,
    HistoriaModalComponent,
  ],
  templateUrl: './inicio.component.html',
  styleUrl: './inicio.component.css',
  viewProviders: [
    provideIcons({
      ionHeartCircleOutline,
      ionChatboxEllipsesOutline,
      ionShareOutline,
      ionBookmarkOutline,
    }),
  ],
})

/* 
TODO: Hacer las rutas ?variant=home || ?variant=following en el url
TODO: Mostrar el perfil en :hover al ver la sugerencia
 */
export class InicioComponent implements OnInit {
  public listaPublicaciones$!: Publicaciones[];
  public listaUsuarios$!: Usuario[];

  error: string = '';
  /* PUBLICACIONES */
  comentarioActual:ComentarioPost = {
    mensaje: ''
  };
  publicacionAbierta: boolean = false;
  publicacionActual: Publicaciones | undefined;
  
  
  
  /* HISTORIAS  */
  historiaAbierta: boolean = false;
  timeline: number = 0;
  pause: boolean = false;

  abrirHistoria(): void {
    this.historiaAbierta = true;
    if(this.pause){
      this.timeline = 0;
    }
    const interval = setInterval(() => {
      this.timeline += 1;
      if(!this.pause){
        if (this.timeline >= 100) {
          clearInterval(interval); // Detiene el intervalo cuando alcanza el 100%
          this.historiaAbierta = false;
          this.timeline = 0;
          console.log('se ha cerrado la historia');
        }
      }else if(this.pause){
        this.timeline = 0;
      }
    }, 100); // Intervalo de tiempo para aumentar gradualmente (300 ms en este caso)
  }
  cerrarHistoria(): void {
    this.historiaAbierta = false;
    this.timeline = 0;
  }
  pararTemporizador():void{
    this.timeline = 0;
  }
  pauseBtn():void{
    this.pause = true;
  }
  playBtn():void{
    this.pause = false;
  }
  /* TODO: Modelo de historia pendiente */

  constructor(
    private service: PublicacionesService,
    private comentariosService: PublicarComentarioService,
    private usuarioService: UsuarioService
  ) {}

  ngOnInit(): void {
    this.service.getPublicaciones().subscribe((data) => {
      this.listaPublicaciones$ = data.reverse();
    });
    this.usuarioService.getUsuarios().subscribe((data) => {
      this.listaUsuarios$ = data;
    });
  }

  postComentario(idPublicacion:number): void {
    
    if (this.comentarioActual.mensaje.length < 3) {
      this.error = 'El comentario debe ser más largo';
      console.log(this.error);
      return;
    }
    this.service.comentar(idPublicacion, this.comentarioActual).subscribe(d => console.log(d))
    this.comentarioActual.mensaje = '';
    console.log('Comentario posteado');
  }

  abrirPublicacion(id: number): void {
    this.publicacionAbierta = true;
    this.publicacionActual = this.listaPublicaciones$[id];    
  }
  cerrarPublicacion(): void {
    this.publicacionAbierta = false;
  }

  darLike(idPublicacion: number): void {
    this.service.darLike(idPublicacion).subscribe(d => console.log(d));
    /* SI LA PUBLI YA TIENE LIKE QUITARLO */
    /* SI LA PUBLI TIENE LIKE MOSTRARLO ROJO */
  }
  compartir(idPublicacion: number): void {
    /* TODO: Esta en standby pero debería aportar un link acortado de la publicación actual */
    console.log('Compartiendo public...');
  }
  guardarPublicacion(idPublicacion: number): void {
    /* TODO: Debe almacenar las publicaciones en el perfil del usuario, sin embargo estas no deben ser públicas */
    console.log('Publicación guardada');
  }
  usuario = {
    id: 0,
    nombre_usuario: 'test_23',
    nombre_completo: 'Test Ing',
    imgPerfil: 'https://picsum.photos/60/60',
  };
}
