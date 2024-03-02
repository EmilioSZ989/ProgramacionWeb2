export class Administrador {
    idAdministrador: number;
    nombreUsuario: string;
    contrasenia: string;

    constructor(idAdministrador: number, nombreUsuario: string, contrasenia: string) {
        this.idAdministrador = idAdministrador;
        this.nombreUsuario = nombreUsuario;
        this.contrasenia = contrasenia;
    }
}
