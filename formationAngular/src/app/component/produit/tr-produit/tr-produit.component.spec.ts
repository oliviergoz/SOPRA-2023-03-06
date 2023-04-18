import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TrProduitComponent } from './tr-produit.component';

describe('TrProduitComponent', () => {
  let component: TrProduitComponent;
  let fixture: ComponentFixture<TrProduitComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TrProduitComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TrProduitComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
