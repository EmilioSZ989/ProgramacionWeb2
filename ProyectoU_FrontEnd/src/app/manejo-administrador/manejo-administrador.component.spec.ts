import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManejoAdministradorComponent } from './manejo-administrador.component';

describe('ManejoAdministradorComponent', () => {
  let component: ManejoAdministradorComponent;
  let fixture: ComponentFixture<ManejoAdministradorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManejoAdministradorComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ManejoAdministradorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
