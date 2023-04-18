export class Adresse {
  public get ville(): string | undefined {
    return this._ville;
  }
  public set ville(value: string | undefined) {
    this._ville = value;
  }
  public get codePostal(): string | undefined {
    return this._codePostal;
  }
  public set codePostal(value: string | undefined) {
    this._codePostal = value;
  }
  public get rue(): string | undefined {
    return this._rue;
  }
  public set rue(value: string | undefined) {
    this._rue = value;
  }
  public get numero(): string | undefined {
    return this._numero;
  }
  public set numero(value: string | undefined) {
    this._numero = value;
  }
  public constructor(
    private _numero?: string,
    private _rue?: string,
    private _codePostal?: string,
    private _ville?: string
  ) {}
}
