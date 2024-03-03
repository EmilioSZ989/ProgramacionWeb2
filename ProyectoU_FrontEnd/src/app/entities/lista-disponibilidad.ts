import { Bus } from "./bus";


export class ListaDisponibilidad {
    idListaDisponibilidad: number;
    destino: string;
    fecha: string;
    horaSalida: string;
    totalPagar: number;
    cupoDisponible: number;
    idBus: Bus;
}
