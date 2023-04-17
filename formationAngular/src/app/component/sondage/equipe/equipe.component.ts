import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Equipe } from 'src/app/model/equipe';

@Component({
  selector: 'app-equipe',
  templateUrl: './equipe.component.html',
  styleUrls: ['./equipe.component.css'],
})
export class EquipeComponent implements OnInit {
  ngOnInit(): void {
    this.equipe = new Equipe(this.nomEquipe);
  }
  @Input('equipe')
  nomEquipe!: string;
  equipe!: Equipe;
  vote: number = 0;
  @Output()
  voteEvent: EventEmitter<Equipe> = new EventEmitter();

  voter() {
    this.vote++;
    this.voteEvent.emit(this.equipe);
  }
}
