export interface User {
    id: number,
    name: string,
    email: string,
    phone: string,
    address: Address,
    password: string,
}

interface Address {
    rua: string,
    bairro: string,
    numero: string,
    cep: string
}