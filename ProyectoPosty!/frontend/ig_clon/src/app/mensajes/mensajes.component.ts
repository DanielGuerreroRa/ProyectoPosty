import { Component, OnInit } from '@angular/core';
import { Usuario } from '../_modelo/Usuario';
import { UsuarioService } from '../_servicio/usuario.service';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import {
  ionAddCircleOutline,
  ionChatboxEllipsesOutline,
  ionHappyOutline,
} from '@ng-icons/ionicons';
import { FormsModule } from '@angular/forms';
import { PickerComponent } from '@ctrl/ngx-emoji-mart';
import { Mensaje } from '../_modelo/Mensaje';
import { MensajeServiceService } from '../_servicio/mensaje-service.service';
@Component({
  selector: 'app-mensajes',
  standalone: true,
  imports: [NgIconComponent, FormsModule, PickerComponent],
  templateUrl: './mensajes.component.html',
  styleUrl: './mensajes.component.css',
  viewProviders: [
    provideIcons({
      ionAddCircleOutline,
      ionHappyOutline,
      ionChatboxEllipsesOutline,
    }),
  ],
})
export class MensajesComponent implements OnInit {
  public listaUsuarios$!: Usuario[];
  public listaMensajes$!: Mensaje[];

  constructor(private usuarioService: UsuarioService, private mensajeService: MensajeServiceService) {}
  
  /* Listar mensajes */
  mensajesActuales: Mensaje[] | undefined;
  public usuarioDestino$: Usuario | undefined;
  usuarioActual = {
    idUsuario: 1,
    nombreUsuario: "jhon_cenaa"
  };

  obtenerMensajesUsuario(id: number) {
    this.mensajeService.getMsgById(id).subscribe(data => {
      this.mensajesActuales = data;
      this.usuarioDestino$ = this.listaUsuarios$.find(usr => usr.idUsuario === id);    
    });
  }

  /*  EMOJI PICKER  */
  emojiPickerOpen: boolean = false;
  abrirEmojiPicker(): void {
    this.emojiPickerOpen = !this.emojiPickerOpen;
  }
  addEmoji(event: any): void {
    this.mensaje += event.emoji.native;
  }
  mensaje: string = '';
  errorMsg: string = '';


  ngOnInit(): void {
    this.usuarioService.getUsuarios().subscribe((data) => {
      this.listaUsuarios$ = data;
    });
  }

  enviarMensaje(): void {
    if (this.mensaje.length < 2) {
      this.errorMsg = 'La longitud del mensaje debe ser superior a 2ch';
    }
    console.log(this.mensaje);
    console.log('mensaje enviado');
    this.mensaje = '';
  }
}
