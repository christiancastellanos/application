import { Component, OnInit, Input, OnDestroy } from '@angular/core';
import { Location } from '@angular/common';

import { Usuario } from '../../model/usuario';
import { UsuariosService } from '../../services/usuarios.service';
import { Subscription } from 'rxjs/Subscription';

@Component({
  selector: 'app-list-usuarios',
  templateUrl: './list-usuarios.component.html',
  styleUrls: ['./list-usuarios.component.css']
})
export class ListUsuariosComponent implements OnInit, OnDestroy {

  usuarios: Usuario[];

  subscription: Subscription;

  @Input()
  editable: boolean;

  constructor(private usuarioService: UsuariosService, private location: Location) { }

  ngOnInit() {
    this.editable = true;
    this.actualiarUsuarios();
  }

  ngOnDestroy() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
  }

  actualiarUsuarios() {
    if (this.subscription) {
      this.subscription.unsubscribe();
    }
    this.subscription = this.usuarioService.getAll().subscribe(usuarios => this.usuarios = usuarios);
  }

  mostraraviso(event):void {
    alert(event.variabledehijoapadre);
  }

}



