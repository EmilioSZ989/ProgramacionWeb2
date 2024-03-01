import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FuncionesAdministradorComponent } from './funciones-administrador.component';

describe('FuncionesAdministradorComponent', () => {
  let component: FuncionesAdministradorComponent;
  let fixture: ComponentFixture<FuncionesAdministradorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FuncionesAdministradorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FuncionesAdministradorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
