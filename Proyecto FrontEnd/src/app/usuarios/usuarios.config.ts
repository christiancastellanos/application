import { AppConfig } from '../app.config';

export class UsuariosConfig {
  public static httpResource: any = {
    usuarios:  AppConfig.SERVER_ADDRESS + '/user'
  };
}