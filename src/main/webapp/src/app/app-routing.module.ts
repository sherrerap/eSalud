import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SidenavComponent} from './components/sidenav/sidenav.component';
import {SidenavAdminComponent} from './components/sidenavAdmin/sidenavAdmin.component';
import { ListadoCitasComponent } from './components/listado-citas/listado-citas.component';
import { AdminComponent } from './components/admin/admin.component';
import { ModificarMedicoComponent } from './components/admin-ModificarMedico/ModificarMedico.component';
import { ModificarPacienteComponent } from './components/admin-ModificarPaciente/ModificarPaciente.component';
import { MostrarMedicoComponent } from './components/admin-MostrarMedico/MostrarMedico.component';
import { RegistrarMedicoComponent } from './components/admin-RegistrarMedico/RegistrarMedico.component';

const routes: Routes = [
  
  {path:'', redirectTo: '/auth/login', pathMatch: 'full'},
  {path: 'auth', loadChildren: './components/auth/auth.module#AuthModule'},
  {path: 'citas', component: SidenavComponent,
  children: [
    { path: '', component: ListadoCitasComponent}
  ]
},
  {path: 'admin', component: SidenavAdminComponent,
  children: [
    { path: '', component: AdminComponent}
  ]
},
  {path: 'admin-ModificarMedico', component: SidenavAdminComponent,
  children: [
    { path: '', component: ModificarMedicoComponent}
  ]
},
  {path: 'admin-ModificarPaciente', component: SidenavAdminComponent,
  children: [
    { path: '', component: ModificarPacienteComponent}
  ]
},
  {path: 'admin-MostrarMedico', component: SidenavAdminComponent,
  children: [
    { path: '', component: MostrarMedicoComponent}
  ]
},
  {path: 'admin-RegistrarMedico', component: SidenavAdminComponent,
  children: [
    { path: '', component: RegistrarMedicoComponent}
  ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
