import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-first',
  templateUrl: './first.component.html',
  styleUrls: ['./first.component.css'],
})
export class FirstComponent implements OnInit {
  texte!: string;
  image!: string;

  ngOnInit(): void {
    //initialisation du component
    this.texte = 'hello';
    this.image =
      'https://medias.maisonsdumonde.com/images/q_auto,f_auto/w_2000/mkp/M22010678_1/cabane-originale-pour-enfant-en-bois-alice.jpg';
  }
}
