import { Component } from '@angular/core';
import { Equipe } from 'src/app/model/equipe';

@Component({
  selector: 'app-sondage',
  templateUrl: './sondage.component.html',
  styleUrls: ['./sondage.component.css'],
})
export class SondageComponent {
  equipe!: string;
  vote: number = 0;

  traitementVote(data: Equipe) {
    console.debug(data);
    if (data.vote > this.vote) {
      this.equipe = data.equipe;
      this.vote = data.vote;
    }
  }
}
