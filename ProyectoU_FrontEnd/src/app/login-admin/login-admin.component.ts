import { Component } from '@angular/core';
import { FormLoginAdminComponent } from '../form-login-admin/form-login-admin.component';

@Component({
  selector: 'app-login-admin',
  standalone: true,
  imports: [FormLoginAdminComponent],
  templateUrl: './login-admin.component.html',
  styleUrl: './login-admin.component.css'
})
export class LoginAdminComponent {

}
