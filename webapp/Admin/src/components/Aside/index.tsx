import { BsCart4 } from "react-icons/bs";

import { NavLink } from "react-router-dom";
import "./styles.css";


function Aside() {
    return (
        <aside className="aside">

            <div className="logo">
                <BsCart4 />
                <span>
                    <span>e</span> 
                    <strong>COMMERCE</strong>
                </span>
            </div>

            <menu className="aside-menu">

                <div className="amenu-top">
                    <ul className="aside-links">
                        <li><NavLink to="/" className="aside-link abtn-default">Dashboard</NavLink></li>
                        <li><NavLink className="aside-link abtn-default" to="/products">Produtos</NavLink></li>
                        <li><NavLink className="aside-link abtn-default" to="/stock">Estoque</NavLink></li>
                    </ul>
                </div>

                <div className="amenu-bottom">
                    <ul className="aside-links">
                        <li><a className="aside-link abtn-success" href="/">Sobre</a></li>
                        <li><a className="aside-link abtn-danger" href="/">Configurações</a></li>
                    </ul>
                </div>

            </menu>
            
        </aside>
    );
}

export default Aside;