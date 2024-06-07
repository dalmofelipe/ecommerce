import { useEffect, useState } from "react";
import { SubmitHandler, useForm, Controller } from "react-hook-form";

import ProductService from '../../services/products.service'
import { getAllCategories } from "../../services/category.service";
import { Category, Product } from "../../types/product.types";
import Card from "../Card";
import "./styles.css";

function ProductDetailForm() {

    const {
        register,
        handleSubmit,
        control,
        reset,
        // watch,
        formState: { errors },
    } = useForm<Product>()

    const onSubmit: SubmitHandler<Product> = async (data) => {
        console.log(data)

        let productService = new ProductService()

        await productService.saveProduct(data)
        reset()
    }

    const [ categories, setCategory ] = useState([ {} as Category ])
    
    useEffect(() => {
        async function run() {
            setCategory(await getAllCategories())
        }

        run()
    }, [])
    
    return (
        <Card title="Produto Edit">
        
            <form onSubmit={handleSubmit(onSubmit)} className="npform">
                
                <div className="npform-row">
                    <div className="npform-group">
                        <label htmlFor="name">Nome</label>

                        <input id="name" 
                            {...register("name", { required: true })} />

                        {errors.name && <small>O campo nome é obrigatório</small>}
                    </div>

                    <div className="npform-group">
                        <label htmlFor="brand">Marca</label>

                        <input id="brand" 
                            {...register("brand", { required: true })} />

                        {errors.brand && <small>Este campo é obrigatório</small>}
                    </div>
                </div>

                <div className="npform-row">
                    <div className="npform-group">
                        <label htmlFor="details">Detalhes</label>

                        <input id="details" 
                            {...register("details", { required: true })} />

                        {errors.details && <small>Este campo é obrigatório</small>}
                    </div>
                </div>

                <div className="npform-row">
                    <div className="npform-group">
                        <label htmlFor="price">Preço</label>

                        <input id="price" type="number" min={0} step={'any'}
                            {...register("salePrice", { required: true })} />

                        {errors.salePrice && <small>Este campo é obrigatório</small>}
                    </div>

                    <div className="npform-group">
                        <label htmlFor="category.name">Categoria</label>

                        <Controller
                            name="category.id"
                            control={control}
                            rules={{ required: 'Este campo é obrigatório' }}
                            render={({ field }) => (
                            <select id="category.name" {...field}>
                                <option value="">Selecione uma categoria</option>
                                {categories && categories.map((c) => {
                                    return (
                                        <option value={c.id} key={c.id}>{c.name}</option>
                                    )
                                })}
                            </select>
                            )}
                        />

                        {errors.category && <span>{errors.category.message}</span>}
                    </div>
                </div>

                <div className="npform-row">
                    <input type="submit" className="npform-btn npbtn-submit"/>
                    <input type="reset" className="npform-btn npbtn-reset"/>
                </div>

            </form>
        
        </Card>
    )
}

export default ProductDetailForm