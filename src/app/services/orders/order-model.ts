export interface Order {
    id?: number,
    userId: number,
    value: number,
    status: string,
}

export interface OrderProduct {
    id?: number,
    orderId: number,
    name: string,
    quantity: number,
    value: number
}

export interface OrderAndProducts {
    id?: number,
    userId: number,
    value: number,
    status: string,
    products: OrderProduct[]
}