import { UsuarioProfile } from "./usuarioprofile";

export class Usuario {
  id: number;
  ssoId: string;
  password: string;
  firstname: string;
  lastname: string;
  email: string;
  listUsuarioProfile: [UsuarioProfile];
}
