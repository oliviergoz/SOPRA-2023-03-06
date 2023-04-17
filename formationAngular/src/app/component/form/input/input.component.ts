import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-input',
  templateUrl: './input.component.html',
  styleUrls: ['./input.component.css'],
})
export class InputComponent {
  @Input()
  etiquette: string = '';
  data: any;

  @Output()
  dataReady: EventEmitter<any> = new EventEmitter();

  sendData() {
    this.dataReady.emit(this.data);
  }
}
