import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DemoSelectorComponent } from './demo-selector.component';

describe('DemoSelectorComponent', () => {
  let component: DemoSelectorComponent;
  let fixture: ComponentFixture<DemoSelectorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DemoSelectorComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DemoSelectorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
