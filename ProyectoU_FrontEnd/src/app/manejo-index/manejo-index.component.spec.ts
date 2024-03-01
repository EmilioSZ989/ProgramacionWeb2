import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManejoIndexComponent } from './manejo-index.component';

describe('ManejoIndexComponent', () => {
  let component: ManejoIndexComponent;
  let fixture: ComponentFixture<ManejoIndexComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ManejoIndexComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ManejoIndexComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
