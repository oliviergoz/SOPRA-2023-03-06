import { Personne } from './personne';

export class Fournisseur extends Personne {
  public constructor(prenom?: string, nom?: string) {
    super(prenom, nom);
  }
}
