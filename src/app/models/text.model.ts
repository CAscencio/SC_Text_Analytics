export class Comentario {
    texto: string;
    emoji: string;
}

export class Texto {
    texto: string;
}

export class Lenguaje {
    texto: string;
    lenguaje: string;
}

export class PalabrasClaves {
    palabras: string[];
}

export class EntidadResponse {
    entidades: Entidad[];
}

export class Entidad {
    entidad: string;
    categoria: string;
}