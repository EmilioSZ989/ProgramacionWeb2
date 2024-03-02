import { TestBed } from '@angular/core/testing';

import { ListaDisponibilidadService } from './lista-disponibilidad.service';

describe('ListaDisponibilidadService', () => {
  let service: ListaDisponibilidadService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ListaDisponibilidadService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
