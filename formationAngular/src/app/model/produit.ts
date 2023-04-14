export class Produit {
  public get nom(): string | undefined {
    return this._nom;
  }
  public set nom(value: string | undefined) {
    this._nom = value;
  }
  public get prix(): number {
    return this._prix;
  }
  public set prix(value: number) {
    this._prix = value;
  }
  // //attributs
  // private nom: string | undefined;
  // private prix: number;

  // public constructor(nom?: string, prix: number = 0) {
  //   this.nom = nom;
  //   this.prix = prix;
  // }

  public constructor(private _nom?: string, private _prix: number = 0) {}

  //methodes

  public infos(): string {
    return this._nom + ' ' + this.prix;
  }

  public get hello(): string {
    return 'hello';
  }
}
