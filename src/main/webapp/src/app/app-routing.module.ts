import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SidenavComponent} from './components/sidenav/sidenav.component';
import { ListadoCitasComponent } from './components/listado-citas/listado-citas.component';
import { AuthGuard } from './_helpers';


const routes: Routes = [
  
  {path:'', redirectTo: '/auth/login', pathMatch: 'full'},
  {path: 'auth', loadChildren: './components/auth/auth.module#AuthModule'},
  {path: 'citas', component: SidenavComponent, canActivate: [AuthGuard],
  children: [
    {path: '', component: ListadoCitasComponent}
  ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
