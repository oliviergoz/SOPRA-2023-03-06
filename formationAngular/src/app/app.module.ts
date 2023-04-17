import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FirstComponent } from './component/first/first.component';
import { AppComponent } from './app.component';
import { ProduitComponent } from './component/produit/produit.component';
import { TestPersonneComponent } from './component/test-personne/test-personne.component';
import { FormsModule } from '@angular/forms';
import { ClientComponent } from './component/client/client/client.component';
import { FormClientComponent } from './component/client/form-client/form-client.component';
import { ShowClientComponent } from './component/client/show-client/show-client.component';
import { InputComponent } from './component/form/input/input.component';

@NgModule({
  declarations: [
    AppComponent,
    FirstComponent,
    ProduitComponent,
    TestPersonneComponent,
    ClientComponent,
    FormClientComponent,
    ShowClientComponent,
    InputComponent,
  ],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
