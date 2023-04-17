import { Directive, ElementRef, OnInit, Renderer2 } from '@angular/core';

@Directive({
  selector: '[important]',
})
export class ImportantDirective implements OnInit {
  constructor(private el: ElementRef, private rendeder: Renderer2) {
    console.debug(this.el);
  }
  ngOnInit(): void {
    this.rendeder.setStyle(this.el.nativeElement, 'background-color', 'yellow');
  }
}
