import { ListaDisponibilidad } from "./lista-disponibilidad";
import { Usuario } from "./usuario";

export class Reserva {
    idReserva: number;
    numeroPuesto: number;
    estado: boolean;
    fechaReserva: Date;
    cedula: Usuario;
    id_lista_disponibilidad: ListaDisponibilidad;
}
