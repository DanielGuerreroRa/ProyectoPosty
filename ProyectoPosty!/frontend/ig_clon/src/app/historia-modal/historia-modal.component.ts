import {
  Component,
  EventEmitter,
  Input,
  OnInit,
  Output,
  input,
} from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NgIconComponent, provideIcons } from '@ng-icons/core';
import { ionPause, ionHeartOutline, ionSendOutline, ionPlay } from '@ng-icons/ionicons';

@Component({
  selector: 'app-historia-modal',
  standalone: true,
  imports: [NgIconComponent, FormsModule],
  templateUrl: './historia-modal.component.html',
  styleUrl: './historia-modal.component.css',
  viewProviders: [
    provideIcons({
      ionPause,
      ionHeartOutline,
      ionSendOutline,
      ionPlay
    }),
  ],
})
export class HistoriaModalComponent {
  @Input() timelineWidth: number = 0;
  @Input() isPaused:boolean = true;

  @Output() cerrar: EventEmitter<any> = new EventEmitter();
  @Output() temporizador: EventEmitter<any> = new EventEmitter();
  @Output() pausar: EventEmitter<any> = new EventEmitter();
  @Output() play: EventEmitter<any> = new EventEmitter();
  imgURL: string = 'https://picsum.photos/2000/2000';
  comentario: string= '';

  mandarCorazon():void{
    console.log('Diste like a esta historia');    
  }
  mandarComentario():void{
    console.log('comentario:', this.comentario);
  }

  close() {
    this.cerrar.emit();
  }
  pararTemporizador(){
    this.temporizador.emit();
  }
  pauseBtn(): void{
    this.pausar.emit();
  }
  playBtn(): void{
    this.play.emit();
  }
}
