import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ModalUsuarioPorBusComponent } from './modal-usuario-por-bus.component';

describe('ModalUsuarioPorBusComponent', () => {
  let component: ModalUsuarioPorBusComponent;
  let fixture: ComponentFixture<ModalUsuarioPorBusComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ModalUsuarioPorBusComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ModalUsuarioPorBusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
