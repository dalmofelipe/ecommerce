import { useState } from "react";
import { Product } from "../types/product.types";
import ProductsContext from "./ProductsContext";

const ProductsProvider = ({ children } : { children: React.ReactNode }) => {

    const [ products, setProducts ] = useState<Product[]>([])

    const productsContext = { products, setProducts }

    return (
        <ProductsContext.Provider value={productsContext}>
            {children}
        </ProductsContext.Provider>
    )
}

export default ProductsProvider