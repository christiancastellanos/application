import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ListUsuariosComponent } from './components/list-usuarios/list-usuarios.component';
import { FormUsuarioComponent } from './components/form-usuario/form-usuario.component';

const routes: Routes = [
  { path: 'usuarios', component: ListUsuariosComponent },
  { path: 'nuevoUsuario', component: FormUsuarioComponent},
  { path: 'editarUsuario/:id', component: FormUsuarioComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})

export class UsuariosRoutingModule {

}
