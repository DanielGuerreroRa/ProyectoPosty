import { Routes } from '@angular/router';
import { InicioComponent } from './inicio/inicio.component';
import { BusquedaComponent } from './busqueda/busqueda.component';
import { ExplorarComponent } from './explorar/explorar.component';
import { ReelsComponent } from './reels/reels.component';
import { MensajesComponent } from './mensajes/mensajes.component';
import { NotificacionesComponent } from './notificaciones/notificaciones.component';
import { PublicarComponent } from './publicar/publicar.component';
import { PerfilComponent } from './perfil/perfil.component';
import { EditarperfilformularioComponent } from './editarperfilformulario/editarperfilformulario.component';

export const routes: Routes = [
  { path: 'busqueda', component: BusquedaComponent },
  { path: 'explorar', component: ExplorarComponent },
  { path: 'reels', component: ReelsComponent },
  { path: 'mensajes', component: MensajesComponent },
  { path: 'notificaciones', component: NotificacionesComponent },
  { path: 'publicar', component: PublicarComponent },
  { path: 'perfil', component: PerfilComponent },
  { path: 'perfil/editar-perfil', component: EditarperfilformularioComponent},
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: '**', component: InicioComponent },
];
