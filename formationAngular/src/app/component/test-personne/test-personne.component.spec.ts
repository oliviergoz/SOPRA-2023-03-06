import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TestPersonneComponent } from './test-personne.component';

describe('TestPersonneComponent', () => {
  let component: TestPersonneComponent;
  let fixture: ComponentFixture<TestPersonneComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TestPersonneComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TestPersonneComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
