import { Component, EventEmitter, Input, Output } from '@angular/core';
import { PublicacionesService } from '../_servicio/publicaciones.service';
import { Publicaciones } from '../_modelo/Publicaciones';
import { PublicacionPublicar } from '../_modelo/PublicacionPublicar';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-publicar-modal',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './publicar-modal.component.html',
  styleUrl: './publicar-modal.component.css',
})
export class PublicarModalComponent {
  @Input() isPosting: boolean = false;
  @Output() cerrar: EventEmitter<any> = new EventEmitter();

  constructor(private publicarService: PublicacionesService) {}

  close() {
    this.cerrar.emit();
  }

  publicacionActual: PublicacionPublicar = {
    descripcion: '',
    rutaContenido: '',
  };
  onFileChange(event: any) {
    const selectedFile = event.target.files[0];

    if (selectedFile) {
      const reader = new FileReader();
      reader.readAsDataURL(selectedFile);
      reader.onload = () => {
        const base64Image = reader.result as string;
        this.publicacionActual.rutaContenido = base64Image; // Store Base64 string
        console.log('Filename:', selectedFile.name);
        console.log('File size:', selectedFile.size);
      };
      reader.onerror = (error) => {
        console.error('Error reading file:', error);
      };
    }
  }

  publicar() {
    if(this.publicacionActual.descripcion.length < 3 || this.publicacionActual.rutaContenido.length < 1){
        alert('Ninguno de los campos puede estar vació, debes aportar una descripción y imagen')
    }else{
      this.publicarService.postPublicacion(1, this.publicacionActual).subscribe((response) => {
        console.log('Respuesta servidor', response);
      });
      this.publicacionActual.descripcion = '';
      this.publicacionActual.rutaContenido = '';
      this.cerrar.emit();
    }
  }
  removerFoto(){
    this.publicacionActual.rutaContenido = '';
  }
}
