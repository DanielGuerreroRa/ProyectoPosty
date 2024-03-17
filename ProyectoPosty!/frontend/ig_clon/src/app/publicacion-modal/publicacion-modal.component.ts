import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Publicaciones } from '../_modelo/Publicaciones';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { ionAddCircleOutline } from '@ng-icons/ionicons';
import { FormsModule } from '@angular/forms';
import { PublicacionesService } from '../_servicio/publicaciones.service';
import { ComentarioPost } from '../_modelo/ComentarioPost';
@Component({
  selector: 'app-publicacion-modal',
  standalone: true,
  imports: [NgIconComponent, FormsModule],
  templateUrl: './publicacion-modal.component.html',
  styleUrl: './publicacion-modal.component.css',
  viewProviders: [provideIcons({ ionAddCircleOutline })],
})
export class PublicacionModalComponent {
  @Input() isOpen: boolean = false;

  @Input() publicacionActual: Publicaciones | undefined;

  @Output() cerrar: EventEmitter<any> = new EventEmitter();
  constructor(private publicacionService: PublicacionesService){}

  comentario: ComentarioPost = {
    mensaje: ''
  };
  error: string = '';

  subirComentario(idPublicacion:number): void {
    /* TODO: añadir usuario logeado para poder postear el comentario! */
    if (this.comentario.mensaje.length < 2) {
      this.error = 'La longitud del comentario debe ser mínimo de 2 caracteres';
      return;
    }
    this.publicacionService.comentar(idPublicacion, this.comentario).subscribe(d => console.log(d))
    this.error = '';
    this.comentario.mensaje = '';
    console.log('Comentario posteado');
  }

  close() {
    this.cerrar.emit();    
  }
}
