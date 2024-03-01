import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormLoginAdminComponent } from './form-login-admin.component';

describe('FormLoginAdminComponent', () => {
  let component: FormLoginAdminComponent;
  let fixture: ComponentFixture<FormLoginAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [FormLoginAdminComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(FormLoginAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
