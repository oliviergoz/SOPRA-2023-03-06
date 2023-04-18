import { Adresse } from './adresse';

export class Fournisseur {
  public get adresse(): Adresse | undefined {
    return this._adresse;
  }
  public set adresse(value: Adresse | undefined) {
    this._adresse = value;
  }
  public get contact(): string | undefined {
    return this._contact;
  }
  public set contact(value: string | undefined) {
    this._contact = value;
  }
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  public constructor(
    private _id?: number,
    private _nom?: string,
    private _contact?: string,
    private _adresse?: Adresse
  ) {}
}
