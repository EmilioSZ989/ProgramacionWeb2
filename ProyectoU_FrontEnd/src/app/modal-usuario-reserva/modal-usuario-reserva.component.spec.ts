import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalUsuarioReservaComponent } from './modal-usuario-reserva.component';

describe('ModalUsuarioReservaComponent', () => {
  let component: ModalUsuarioReservaComponent;
  let fixture: ComponentFixture<ModalUsuarioReservaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalUsuarioReservaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModalUsuarioReservaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
