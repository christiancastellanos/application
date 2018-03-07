import { Component, OnInit, Input, Output } from '@angular/core';

import { Usuario } from '../../model/usuario';
import { UsuariosService } from '../../services/usuarios.service';
import { EventEmitter } from '@angular/core';

@Component({
  selector: 'app-list-item-usuario',
  templateUrl: './list-item-usuario.component.html',
  styleUrls: ['./list-item-usuario.component.css']
})

export class ListItemUsuarioComponent implements OnInit {

  @Input()
  usuario: Usuario;

  @Input()
  editable: boolean;

  @Output()
  eliminado: EventEmitter<any> = new EventEmitter();

  @Output()
  aviso: EventEmitter<any> = new EventEmitter();

  public variabledehijoapadre:string 
  
  constructor(private usuarioService: UsuariosService) { }

  ngOnInit() {
  }

  eliminarUsuario() {
    if (confirm(`Desea eliminar la usuario ${this.usuario.ssoId}?`)) {
      this.usuarioService.delete(this.usuario.ssoId).subscribe(() => this.eliminado.emit(this.usuario.ssoId));
    }
  }

  advertenciacapturadatosenhijo() {
    alert(this.usuario.firstname+" +++ "+this.usuario.lastname);
  }

  avisocapturadatospasaapadre(event) {
    this.aviso.emit({variabledehijoapadre: this.usuario.firstname+" --- "+this.usuario.lastname});
  }

}

