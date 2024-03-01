import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalConsultaReservaComponent } from './modal-consulta-reserva.component';

describe('ModalConsultaReservaComponent', () => {
  let component: ModalConsultaReservaComponent;
  let fixture: ComponentFixture<ModalConsultaReservaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalConsultaReservaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModalConsultaReservaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
