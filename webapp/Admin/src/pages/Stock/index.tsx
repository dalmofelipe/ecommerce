import { VscExtensions } from "react-icons/vsc";
import Content from "../../components/Content";

import "./styles.css";

function Stock() {
    return (
        <Content icon={<VscExtensions />} title="Estoque">
            <div className="stock">
                Estoque
            </div>
        </Content>
    )
}

export default Stock