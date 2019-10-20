import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import {MatSidenavModule} from '@angular/material/sidenav';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; 
import {MatListModule, MatIconModule, MatToolbarModule,MatTableModule,MatSortModule,MatPaginatorModule} from '@angular/material';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';


import { AppComponent } from './app.component';
import { SidenavComponent } from './components/sidenav/sidenav.component'; 
import { SidenavAdminComponent } from './components/sidenavAdmin/sidenavAdmin.component'; 
import { ListadoCitasComponent } from './components/listado-citas/listado-citas.component';
import { AdminComponent } from './components/admin/admin.component';
import { ModificarMedicoComponent } from './components/admin-ModificarMedico/ModificarMedico.component';
import { ModificarPacienteComponent } from './components/admin-ModificarPaciente/ModificarPaciente.component';
import { MostrarMedicoComponent } from './components/admin-MostrarMedico/MostrarMedico.component';
import { RegistrarMedicoComponent } from './components/admin-RegistrarMedico/RegistrarMedico.component';


@NgModule({
  declarations: [
    AppComponent,
    SidenavComponent,
	SidenavAdminComponent,
    ListadoCitasComponent,
	AdminComponent,
	ModificarMedicoComponent,
	ModificarPacienteComponent,
	MostrarMedicoComponent,
	RegistrarMedicoComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSidenavModule,
    MatListModule,
    MatIconModule, 
    MatToolbarModule,
    FormsModule,
    ReactiveFormsModule,
	MatTableModule,
	MatSortModule,
	MatPaginatorModule
	
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
