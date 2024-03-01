import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManejoUsuariosComponent } from './manejo-usuarios.component';

describe('ManejoUsuariosComponent', () => {
  let component: ManejoUsuariosComponent;
  let fixture: ComponentFixture<ManejoUsuariosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManejoUsuariosComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ManejoUsuariosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
