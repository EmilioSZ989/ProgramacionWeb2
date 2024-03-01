import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PresentacionEmpresaComponent } from './presentacion-empresa.component';

describe('PresentacionEmpresaComponent', () => {
  let component: PresentacionEmpresaComponent;
  let fixture: ComponentFixture<PresentacionEmpresaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PresentacionEmpresaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(PresentacionEmpresaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
