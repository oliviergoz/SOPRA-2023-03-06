import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-bonjour',
  templateUrl: './bonjour.component.html',
  styleUrls: ['./bonjour.component.css'],
})
export class BonjourComponent implements OnInit {
  prenom = '';

  constructor(private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {
    // this.prenom = this.activatedRoute.snapshot.params['prenom'];
    this.activatedRoute.params.subscribe((params) => {
      this.prenom = params['prenom'];
    });
  }
}
