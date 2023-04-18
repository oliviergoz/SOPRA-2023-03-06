import { Routes } from '@angular/router';
import { ProduitComponent } from './component/produit/produit.component';
import { SondageComponent } from './component/sondage/sondage/sondage.component';
import { HomeComponent } from './component/home/home.component';
import { BonjourComponent } from './component/bonjour/bonjour.component';

export const routes: Routes = [
  { path: 'produit', component: ProduitComponent },
  { path: 'sondage', component: SondageComponent },
  { path: 'home', component: HomeComponent },
  { path: 'bonjour/:prenom', component: BonjourComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
];
