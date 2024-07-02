import React, { createContext } from "react"
import { Product } from "../types/product.types"

interface IProductsContext {
    products: Product[]
    setProducts: React.Dispatch<React.SetStateAction<Product[]>>
}

const ProductsContext = createContext({} as IProductsContext)

export default ProductsContext