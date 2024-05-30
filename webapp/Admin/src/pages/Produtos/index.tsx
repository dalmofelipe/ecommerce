import { VscArchive } from "react-icons/vsc";
import Content from "../../components/Content";
import Products from "../../components/ProductsTable";
import ProductDetailForm from "../../components/ProductDetailForm";

import "./styles.css";

function Produtos() {
    return (
        <Content icon={<VscArchive />} title="Produtos">
            <ProductDetailForm />
            <Products />
        </Content>
    )
}

export default Produtos