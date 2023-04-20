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
import { ClientGuardService } from './services/client-guard.service';
import { AnonymousGuardService } from './services/anonymous-guard.service';
import { AuthGuardService } from './services/auth-guard.service';
import { AdminGuardService } from './services/admin-guard.service';
import { UserGuardService } from './services/user-guard.service';
import { FormulaireComponent } from './components/formulaire/formulaire.component';
import { InscriptionComponent } from './components/inscription/inscription.component';

const routes: Routes = [
  { path: 'home', component: HomeComponent },
  {
    path: 'login',
    component: LoginComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'produit',
    component: ListProduitComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'produit/add',
    component: EditProduitComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'produit/edit/:id',
    component: EditProduitComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'fournisseur',
    component: ListFournisseurComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'fournisseur/add',
    component: EditFournisseurComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'fournisseur/edit/:id',
    component: EditFournisseurComponent,
    canActivate: [AdminGuardService],
  },
  {
    path: 'client',
    component: ListClientComponent,
    canActivate: [AdminGuardService],
  },
  { path: 'formulaire', component: FormulaireComponent },
  {
    path: 'inscription',
    component: InscriptionComponent,
    canActivate: [AnonymousGuardService],
  },
  {
    path: 'client/:id',
    component: EditClientComponent,
    canActivate: [AdminGuardService],
  },
  { path: 'achat', component: AchatComponent, canActivate: [UserGuardService] },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  { path: '**', component: NotFoundComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
