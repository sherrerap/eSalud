import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {SidenavComponent} from './components/sidenav/sidenav.component';
import {SidenavAdminComponent} from './components/sidenavAdmin/sidenavAdmin.component';
import { ListadoCitasComponent } from './components/listado-citas/listado-citas.component';
import { AdminComponent } from './components/admin/admin.component';

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
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
