import { VscDiffAdded } from "react-icons/vsc";
import { Link } from "react-router-dom";

import { ReactNode } from "react";
import "./styles.css";

type CardProps = {
    title?:string
    footer?:ReactNode
    actions?: ReactNode
    children:ReactNode
}

function Card({title, footer, actions, children}:CardProps) {
    return (
        <article className="card">
            <header>
                <h3>{title ? title : ""}</h3>

                {
                    actions ? 
                    <menu>
                        <Link to={"/"} className="">
                            <VscDiffAdded />
                            <span>CardAction</span>
                        </Link>
                    </menu>
                    : <></>
                }
            </header>

            <main>
                {children}
            </main>

            {footer ? footer : <></>}
        </article>
    )
}

export default Card;
