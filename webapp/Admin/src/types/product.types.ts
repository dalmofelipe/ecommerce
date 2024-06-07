type Category = {
    id: number
    name?: string
    categoryRoot: string
}

type Product = {
    id: number
    name: string
    brand: string
    details: string
    salePrice: number
    category: Category
}

export type {
    Product,
    Category
}