export class Usuario {
    cedula: number;
    nombre: string;
    apellidos: string;
    telefono: string;
    fechaNacimiento: Date;

    constructor(
        cedula: number,
        nombre: string,
        apellidos: string,
        telefono: string,
        fechaNacimiento: Date
    ) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }
}
