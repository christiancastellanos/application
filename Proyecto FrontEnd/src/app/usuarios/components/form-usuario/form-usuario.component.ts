import { Component, OnInit } from '@angular/core';
import { Location } from '@angular/common';
import { ActivatedRoute } from '@angular/router';

import { Usuario } from '../../model/usuario';
import { UsuarioProfile } from '../../model/usuarioprofile';
import { UsuariosService } from '../../services/usuarios.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-form-usuario',
  templateUrl: './form-usuario.component.html',
  styleUrls: ['./form-usuario.component.css']
})
export class FormUsuarioComponent implements OnInit {

  usuario: Usuario;
  perfiles: UsuarioProfile[];
  subscription: Subscription;

  constructor( private usuariosServices: UsuariosService, private location: Location, private activateRoute: ActivatedRoute) { }

  ngOnInit() {
    const id: string = this.activateRoute.snapshot.paramMap.get('id');
    if (!id) {
      this.usuario = new Usuario();
    } else {
      this.usuariosServices.get(parseInt(id)).subscribe(usuario => this.usuario = usuario);
    }
    this.mostrarTiposUsuarios();
  }

  enviarUsuario(usuario: Usuario) {
    if (!usuario.id) {
      this.usuariosServices.create(usuario).subscribe(() => this.location.back());
    } else {
      this.usuariosServices.update(usuario).subscribe(() => this.location.back());
    }

  }

  mostrarTiposUsuarios() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
    this.subscription = this.usuariosServices.getTypes().subscribe(perfiles => this.perfiles = perfiles);
  }

  cancelar() {
    this.location.back();
  }

}
