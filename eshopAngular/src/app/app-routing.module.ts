import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { ListProduitComponent } from './components/produit/list-produit/list-produit.component';
import { EditProduitComponent } from './components/produit/edit-produit/edit-produit.component';
import { ListFournisseurComponent } from './components/fournisseur/list-fournisseur/list-fournisseur.component';
import { EditFournisseurComponent } from './components/fournisseur/edit-fournisseur/edit-fournisseur.component';
import { ListClientComponent } from './components/client/list-client/list-client.component';
import { EditClientComponent } from './components/client/edit-client/edit-client.component';
import { AchatComponent } from './components/achat/achat/achat.component';
import { NotFoundComponent } from './components/not-found/not-found.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  { path: 'login', component: LoginComponent },
  { path: 'produit', component: ListProduitComponent },
  { path: 'produit/:id', component: EditProduitComponent },
  { path: 'fournisseur', component: ListFournisseurComponent },
  { path: 'fournisseur/add', component: EditFournisseurComponent },
  { path: 'fournisseur/edit/:id', component: EditFournisseurComponent },
  { path: 'client', component: ListClientComponent },
  { path: 'client/:id', component: EditClientComponent },
  { path: 'achat', component: AchatComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
