import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { UsuarioService } from '../_servicio/usuario.service';
import { Usuario } from '../_modelo/Usuario';
import { PublicacionesService } from '../_servicio/publicaciones.service';
import { Publicaciones } from '../_modelo/Publicaciones';

@Component({
  selector: 'app-perfil',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './perfil.component.html',
  styleUrl: './perfil.component.css',
})
export class PerfilComponent implements OnInit {
  public perfilUsuario$!: Usuario;
  public listaPublicaciones$!: Publicaciones[];
  constructor(
    private usuarioService: UsuarioService,
    private publicacionService: PublicacionesService
  ) {}

  fotoPerfilActual: string = '';
  usuarioActual:string = '';

  ngOnInit(): void {
    this.usuarioService.getUsuarioId().subscribe((data) => {
      this.perfilUsuario$ = data;
      if(this.perfilUsuario$){
        this.fotoPerfilActual = this.perfilUsuario$.fotoPerfil;
        this.usuarioActual = this.perfilUsuario$.nombreUsuario;
        
      }
    });
    this.publicacionService
      .getPublicaciones()
      .subscribe((data) => (this.listaPublicaciones$ = data));
  }
}
