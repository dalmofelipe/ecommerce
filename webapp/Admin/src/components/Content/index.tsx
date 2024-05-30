import { ReactNode } from "react";
import "./styles.css";

type ContentProps = { 
    title:string
    icon:ReactNode
    children:ReactNode
}

function Content({title, icon, children}:ContentProps) {
    return (
        <main className="content">
            <header style={{fontSize: "30px", fontWeight: 300}} >
                {icon} {title}
            </header>

            {children}
        </main>
    );
}

export default Content;