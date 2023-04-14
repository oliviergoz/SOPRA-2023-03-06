import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FirstComponent } from './component/first/first.component';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [AppComponent, FirstComponent],
  imports: [BrowserModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
