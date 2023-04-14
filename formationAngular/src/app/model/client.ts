import { Personne } from './personne';
import { TypeClient } from './type-client';

export class Client extends Personne {
  public get type(): TypeClient {
    return this._type;
  }
  public set type(value: TypeClient) {
    this._type = value;
  }
  public constructor(
    prenom?: string,
    nom?: string,
    private _type: TypeClient = TypeClient.Particulier
  ) {
    super(prenom, nom);
  }
}
