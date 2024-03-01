import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalReservasPorDiaComponent } from './modal-reservas-por-dia.component';

describe('ModalReservasPorDiaComponent', () => {
  let component: ModalReservasPorDiaComponent;
  let fixture: ComponentFixture<ModalReservasPorDiaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalReservasPorDiaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModalReservasPorDiaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
