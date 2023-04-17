import { Directive, ElementRef, Renderer2 } from '@angular/core';

@Directive({
  selector: '[primary-button]',
})
export class PrimaryButtonDirective {
  constructor(private el: ElementRef, private rendeder: Renderer2) {}
  ngOnInit(): void {
    this.rendeder.addClass(this.el.nativeElement, 'btn');
    this.rendeder.addClass(this.el.nativeElement, 'btn-outline-primary');
  }
}
