import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Perfilusuario } from '../_modelo/perfilusuario';
import { PerfilService } from '../_servicio/perfil.service';

@Component({
  selector: 'app-editarperfilformulario',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './editarperfilformulario.component.html',
  styleUrl: './editarperfilformulario.component.css',
})
export class EditarperfilformularioComponent implements OnInit {
  pu: Perfilusuario = {
    idPerfil: 1,
    nombreUsuario: '',
    contrasena: '',
    correo: '',
    fotoPerfil: '',
  };
  ngOnInit(): void {
    this.servicio.obtenerPerfil(1).subscribe((data) => {
      this.pu = data;      
    });
  }

  constructor(private servicio: PerfilService) {}

  guardarCambios() {
    this.servicio
      .actualizarPerfil(this.pu)
      .subscribe(() => console.log('se ha cambiado'));
  }
}
