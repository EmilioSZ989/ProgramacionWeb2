import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListaDisponibilidaComponent } from './lista-disponibilida.component';

describe('ListaDisponibilidaComponent', () => {
  let component: ListaDisponibilidaComponent;
  let fixture: ComponentFixture<ListaDisponibilidaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ListaDisponibilidaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ListaDisponibilidaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
