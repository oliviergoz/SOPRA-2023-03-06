import { Fournisseur } from './fournisseur';

export class Produit {
  public get fournisseur(): Fournisseur | undefined {
    return this._fournisseur;
  }
  public set fournisseur(value: Fournisseur | undefined) {
    this._fournisseur = value;
  }
  public get description(): string | undefined {
    return this._description;
  }
  public set description(value: string | undefined) {
    this._description = value;
  }
  public get prix(): number | undefined {
    return this._prix;
  }
  public set prix(value: number | undefined) {
    this._prix = value;
  }
  public get libelle(): string | undefined {
    return this._libelle;
  }
  public set libelle(value: string | undefined) {
    this._libelle = value;
  }
  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }
  public constructor(
    private _id?: number,
    private _libelle?: string,
    private _prix?: number,
    private _description?: string,
    private _fournisseur?: Fournisseur
  ) {}
}
