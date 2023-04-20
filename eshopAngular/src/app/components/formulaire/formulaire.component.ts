import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { CustomValidator } from 'src/app/validators/custom-validator';

@Component({
  selector: 'app-formulaire',
  templateUrl: './formulaire.component.html',
  styleUrls: ['./formulaire.component.css'],
})
export class FormulaireComponent implements OnInit {
  form!: FormGroup;

  ngOnInit(): void {
    this.form = new FormGroup({
      control1: new FormControl('', [
        Validators.required,
        CustomValidator.totoInterdit,
        CustomValidator.chaineInterdite('zozo'),
      ]),
      control2: new FormControl('', [
        Validators.required,
        Validators.maxLength(5),
      ]),
      groupEgalite: new FormGroup(
        {
          testControlEgaux1: new FormControl(),
          testControlEgaux2: new FormControl(),
        },
        CustomValidator.controlsEgauxInterdit
      ),
    });
  }

  submit() {
    console.debug(this.form);
    console.debug(this.form.get('groupEgalite.testControlEgaux1')?.value);
  }
}
