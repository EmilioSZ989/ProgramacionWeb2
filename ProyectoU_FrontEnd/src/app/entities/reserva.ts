import { ListaDisponibilidad } from "./lista-disponibilidad";
import { Usuario } from "./usuario";


export class Reserva {
    idReserva: number;
    numeroPuesto: number;
    estado: boolean;
    fechaReserva: Date;
    cedula: Usuario; // Relación con la entidad Usuario
    idListaDisponibilidad: ListaDisponibilidad; // Relación con la entidad ListaDisponibilidad

    constructor(
        idReserva: number,
        numeroPuesto: number,
        estado: boolean,
        fechaReserva: Date,
        cedula: Usuario,
        idListaDisponibilidad: ListaDisponibilidad
    ) {
        this.idReserva = idReserva;
        this.numeroPuesto = numeroPuesto;
        this.estado = estado;
        this.fechaReserva = fechaReserva;
        this.cedula = cedula;
        this.idListaDisponibilidad = idListaDisponibilidad;
    }
}
