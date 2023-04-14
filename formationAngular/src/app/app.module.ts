import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FirstComponent } from './component/first/first.component';
import { AppComponent } from './app.component';
import { ProduitComponent } from './component/produit/produit.component';

@NgModule({
  declarations: [AppComponent, FirstComponent, ProduitComponent],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
