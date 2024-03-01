import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalRegistroPagoComponent } from './modal-registro-pago.component';

describe('ModalRegistroPagoComponent', () => {
  let component: ModalRegistroPagoComponent;
  let fixture: ComponentFixture<ModalRegistroPagoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalRegistroPagoComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModalRegistroPagoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
