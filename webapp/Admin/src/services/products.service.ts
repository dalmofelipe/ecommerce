import { Product } from "../types/product.types";

class ProductService {

    private BASE_URL:string

    constructor() {
        this.BASE_URL = process.env.REACT_APP_ECOMMERCE_API_URL as string
    }

    async getProducts() {
        return await fetch(this.BASE_URL + "/products")
            .then(response => response.json())
            .catch(error => console.error(error));
    }

    async saveProduct(data:Product) {
        try {
            const response = await fetch(this.BASE_URL + "/products", {
                method: 'POST',
                headers: {
                'Content-Type': 'application/json',
                },
                body: JSON.stringify({...data, category_id: data.category.id}),
            });
        
            if (!response.ok) {
                throw new Error('Error__saveProduct: Network response was not ok');
            }
        
            const responseData = await response.json();
            return responseData            
        } catch (error) {
            console.error(`Error: ${(error as Error).message}`);
        }
    }
}

export default ProductService