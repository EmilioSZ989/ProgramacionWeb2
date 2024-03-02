import { Bus } from "./bus";


export class ListaDisponibilidad {
    idListaDisponibilidad: number;
    destino: string;
    fecha: string;
    horaSalida: string;
    totalPagar: number;
    cupoDisponible: number;
    idBus: Bus; // Relación con la entidad Bus

    constructor(
        idListaDisponibilidad: number,
        destino: string,
        fecha: string,
        horaSalida: string,
        totalPagar: number,
        cupoDisponible: number,
        idBus: Bus
    ) {
        this.idListaDisponibilidad = idListaDisponibilidad;
        this.destino = destino;
        this.fecha = fecha;
        this.horaSalida = horaSalida;
        this.totalPagar = totalPagar;
        this.cupoDisponible = cupoDisponible;
        this.idBus = idBus;
    }
}
