import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { UsuariosRoutingModule } from './usuarios-routing.module';
import { FormsModule } from '@angular/forms';
import { UsuariosService } from './services/usuarios.service';

import { ListItemUsuarioComponent } from './components/list-item-usuario/list-item-usuario.component';
import { ListUsuariosComponent } from './components/list-usuarios/list-usuarios.component';
import { FormUsuarioComponent } from './components/form-usuario/form-usuario.component';

@NgModule({
  imports: [
    CommonModule,
    HttpClientModule,
    UsuariosRoutingModule,
    FormsModule
  ],
  declarations: [ListItemUsuarioComponent, ListUsuariosComponent, FormUsuarioComponent],
  providers: [UsuariosService],
  exports: [ListItemUsuarioComponent, ListUsuariosComponent, FormUsuarioComponent]
})

export class UsuariosModule { }
