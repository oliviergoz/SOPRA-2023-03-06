import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { HomeComponent } from './components/home/home.component';
import { ListProduitComponent } from './components/produit/list-produit/list-produit.component';
import { EditProduitComponent } from './components/produit/edit-produit/edit-produit.component';
import { ListFournisseurComponent } from './components/fournisseur/list-fournisseur/list-fournisseur.component';
import { EditFournisseurComponent } from './components/fournisseur/edit-fournisseur/edit-fournisseur.component';
import { EditClientComponent } from './components/client/edit-client/edit-client.component';
import { ListClientComponent } from './components/client/list-client/list-client.component';
import { LoginComponent } from './components/login/login.component';
import { AchatComponent } from './components/achat/achat/achat.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { LinkComponent } from './components/link/link.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    NavBarComponent,
    HomeComponent,
    ListProduitComponent,
    EditProduitComponent,
    ListFournisseurComponent,
    EditFournisseurComponent,
    EditClientComponent,
    ListClientComponent,
    LoginComponent,
    AchatComponent,
    NotFoundComponent,
    LinkComponent,
  ],
  imports: [BrowserModule, AppRoutingModule, HttpClientModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
