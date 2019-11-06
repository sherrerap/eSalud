import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { SidenavComponent } from './components/sidenav/sidenav.component';
import { SidenavAdminComponent } from './components/sidenavAdmin/sidenavAdmin.component';
import { ListadoCitasComponent } from './components/listado-citas/listado-citas.component';
import { ModificarMedicoComponent } from './components/admin-ModificarMedico/ModificarMedico.component';
import { ModificarPacienteComponent } from './components/admin-ModificarPaciente/ModificarPaciente.component';
import { MostrarMedicoComponent } from './components/admin-MostrarMedico/MostrarMedico.component';
import { RegistrarMedicoComponent } from './components/admin-RegistrarMedico/RegistrarMedico.component';
import { RegistrarCitaComponent } from './components/paciente-RegistrarCita/RegistrarCita.component';


import { AuthGuard } from './_helpers';



const routes: Routes = [

  { path: '', redirectTo: '/auth/login', pathMatch: 'full' },
  { path: 'auth', loadChildren: './components/auth/auth.module#AuthModule' },
  { path: 'citas/RegistrarCita/citas', redirectTo: 'citas' },
  { path: 'citas/RegistrarCita/RegistrarCita', redirectTo: 'citas/RegistrarCita' },
  {
    path: 'citas', component: SidenavComponent, canActivate: [AuthGuard],
    children: [
      { path: '', component: ListadoCitasComponent }
    ]
  },
  {
    path: 'citas/RegistrarCita', component: SidenavComponent, canActivate: [AuthGuard],
    children: [
      { path: '', component: RegistrarCitaComponent }
    ]
  },

  {
    path: 'admin', component: SidenavAdminComponent, canActivate: [AuthGuard],
    children: [
      { path: '', component: MostrarMedicoComponent }
    ]
  },
  /********************************************************************************** */
  {
    path: 'admin/ModificarMedico', component: SidenavAdminComponent, canActivate: [AuthGuard],
    children: [
      { path: '', component: ModificarMedicoComponent }
    ]
  },
  { path: 'admin/ModificarMedico/ModificarMedico', redirectTo: 'admin/ModificarMedico' },
  { path: 'admin/ModificarMedico/MostrarMedico', redirectTo: 'admin/MostrarMedico' },
  { path: 'admin/ModificarMedico/ModificarPaciente', redirectTo: 'admin/ModificarPaciente' },
  { path: 'admin/ModificarMedico/RegistrarMedico', redirectTo: 'admin/RegistrarMedico' },

  /********************************************************************************** */
  {
    path: 'admin/ModificarPaciente', component: SidenavAdminComponent, canActivate: [AuthGuard],
    children: [
      { path: '', component: ModificarPacienteComponent }
    ]
  },
  { path: 'admin/ModificarPaciente/ModificarMedico', redirectTo: 'admin/ModificarMedico' },
  { path: 'admin/ModificarPaciente/MostrarMedico', redirectTo: 'admin/MostrarMedico' },
  { path: 'admin/ModificarPaciente/ModificarPaciente', redirectTo: 'admin/ModificarPaciente' },
  { path: 'admin/ModificarPaciente/RegistrarMedico', redirectTo: 'admin/RegistrarMedico' },
  /********************************************************************************** */
  {
    path: 'admin/MostrarMedico', component: SidenavAdminComponent, canActivate: [AuthGuard],
    children: [
      { path: '', component: MostrarMedicoComponent }
    ]
  },
  { path: 'admin/MostrarMedico/ModificarMedico', redirectTo: 'admin/ModificarMedico' },
  { path: 'admin/MostrarMedico/MostrarMedico', redirectTo: 'admin/MostrarMedico' },
  { path: 'admin/MostrarMedico/ModificarPaciente', redirectTo: 'admin/ModificarPaciente' },
  { path: 'admin/MostrarMedico/RegistrarMedico', redirectTo: 'admin/RegistrarMedico' },
  /********************************************************************************** */
  {
    path: 'admin/RegistrarMedico', component: SidenavAdminComponent, canActivate: [AuthGuard],
    children: [
      { path: '', component: RegistrarMedicoComponent }
    ]
  },
  { path: 'admin/RegistrarMedico/ModificarMedico', redirectTo: 'admin/ModificarMedico' },
  { path: 'admin/RegistrarMedico/MostrarMedico', redirectTo: 'admin/MostrarMedico' },
  { path: 'admin/RegistrarMedico/ModificarPaciente', redirectTo: 'admin/ModificarPaciente' },
  { path: 'admin/RegistrarMedico/RegistrarMedico', redirectTo: 'admin/RegistrarMedico' },
  /********************************************************************************** */
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
