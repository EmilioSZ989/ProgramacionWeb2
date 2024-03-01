import { Routes } from '@angular/router';
import { ManejoUsuariosComponent } from './manejo-usuarios/manejo-usuarios.component';
import { ManejoIndexComponent } from './manejo-index/manejo-index.component';
import { ManejoAdministradorComponent } from './manejo-administrador/manejo-administrador.component';
import { ModalConsultaReservaComponent } from './modal-consulta-reserva/modal-consulta-reserva.component';
import { LoginAdminComponent } from './login-admin/login-admin.component';

export const routes: Routes = [
    {path:"manejo-usuarios",component: ManejoUsuariosComponent},
    {path:"manejo-index", component: ManejoIndexComponent},
    {path:"manejo-administrador", component: ManejoAdministradorComponent},
    {path:"modal-consultaReserva", component: ModalConsultaReservaComponent},
    {path:"login-admin", component: LoginAdminComponent}
];
