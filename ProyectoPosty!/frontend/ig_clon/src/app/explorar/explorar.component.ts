import { Component, OnInit } from '@angular/core';
import { Usuario } from '../_modelo/Usuario';
import { UsuariosService } from '../_servicio/usuarios.service';

@Component({
  selector: 'app-explorar',
  templateUrl: './explorar.component.html',
  styleUrls: ['./explorar.component.css']
})
export class ExplorarComponent implements OnInit {
 
  public imagenesUsuario$!: Usuario[];

  constructor(private service: UsuariosService) {}
  ngOnInit(): void {
    this.service.getImagenUsuarios('nombreDeLaRuta').subscribe((data) => {
      this.imagenesUsuario$ = data;      
      console.log(data);
      
    });
  }
  
}