import { Component, OnInit } from '@angular/core';
import { PublicarModalComponent } from '../publicar-modal/publicar-modal.component';

@Component({
  selector: 'app-publicar',
  standalone: true,
  imports: [PublicarModalComponent],
  templateUrl: './publicar.component.html',
  styleUrl: './publicar.component.css',
})

export class PublicarComponent implements OnInit{
  ngOnInit(): void {
    this.isPosting = true;
  }
  isPosting: boolean = true;
  abrirPosting() {
    this.isPosting = true;
  }
  cerrarPosting() {
    this.isPosting = false;
  }
}
