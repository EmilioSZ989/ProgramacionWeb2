import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalModificarReservaComponent } from './modal-modificar-reserva.component';

describe('ModalModificarReservaComponent', () => {
  let component: ModalModificarReservaComponent;
  let fixture: ComponentFixture<ModalModificarReservaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalModificarReservaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModalModificarReservaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
