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
import { EquipeComponent } from './component/sondage/equipe/equipe.component';
import { SondageComponent } from './component/sondage/sondage/sondage.component';
import { DirectiveComponent } from './component/directive/directive.component';
import { FormProduitComponent } from './form-produit/form-produit.component';
import { ImportantDirective } from './directive/important.directive';
import { LinkDirective } from './directive/bootstrap/link.directive';
import { WarningButtonDirective } from './directive/bootstrap/warning-button.directive';
import { PrimaryButtonDirective } from './directive/bootstrap/primary-button.directive';
import { DangerButtonDirective } from './directive/bootstrap/danger-button.directive';

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
    EquipeComponent,
    SondageComponent,
    DirectiveComponent,
    FormProduitComponent,
    ImportantDirective,
    LinkDirective,
    WarningButtonDirective,
    PrimaryButtonDirective,
    DangerButtonDirective,
  ],
  imports: [BrowserModule, FormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
