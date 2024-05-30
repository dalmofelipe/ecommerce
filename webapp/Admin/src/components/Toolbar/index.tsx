import { FiMenu, FiX } from "react-icons/fi";

import "./styles.css";


function Toolbar() {
    return (
        <menu className="toolbar">

            <div className="tb-toggle">
                <FiX />
                <FiMenu />
            </div>

            <div className="tb-container">
                <div className="tb-left">
                    <ul className="tb-links">
                        <li><a className="tb-link" href="/">Action1</a></li>
                        <li><a className="tb-link" href="/">Action2</a></li>
                        <li><a className="tb-link" href="/">Action3</a></li>
                        <li><a className="tb-link" href="/">Action4</a></li>
                    </ul>
                </div>

                <div className="tb-right">
                    <ul className="tb-links">
                        <li><a className="tb-link" href="/">configurações</a></li>
                        <li><a className="tb-link" href="/">sair</a></li>
                    </ul>
                </div>
            </div>

        </menu>
    )
}

export default Toolbar;