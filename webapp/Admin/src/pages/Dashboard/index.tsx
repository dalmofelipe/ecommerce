import { useEffect } from "react";
import { VscGear } from "react-icons/vsc";
import Content from "../../components/Content";

import "./styles.css";

function Dashboard() {

    useEffect(() => {}, [])

    return (
        <Content icon={<VscGear />} title="Dashboard">

            <article style={{
                    maxWidth: "1600px",
                    margin: "20px 0", 
                    borderRadius: "5px",
                    backgroundColor: "#f8f9f9",
                    padding: "20px",
                    boxShadow: "2px 2px 2px 1px rgba(0, 0, 0, 0.1)"
                }}>
                <h3>Titulo</h3>
                <p>Mussum Ipsum, cacilds vidis litro abertis.  Leite de capivaris, leite de mula manquis sem cabeça. Suco de cevadiss deixa as pessoas mais interessantis. Quem manda na minha terra sou euzis! Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl.</p>
                <p>Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. Diuretics paradis num copo é motivis de denguis. Não sou faixa preta cumpadi, sou preto inteiris, inteiris. Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis.</p>
                <p>Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Quem num gosta di mim que vai caçá sua turmis! Paisis, filhis, espiritis santis. Delegadis gente finis, bibendum egestas augue arcu ut est.</p>
                <p>In elementis mé pra quem é amistosis quis leo. Sapien in monti palavris qui num significa nadis i pareci latim. Leite de capivaris, leite de mula manquis sem cabeça. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per.</p>
                <p>Detraxit consequat et quo num tendi nada. Delegadis gente finis, bibendum egestas augue arcu ut est. Sapien in monti palavris qui num significa nadis i pareci latim. Per aumento de cachacis, eu reclamis.</p>
            </article>


            <article style={{
                    maxWidth: "1600px",
                    margin: "20px auto", 
                    borderRadius: "5px",
                    backgroundColor: "#f8f9f9",
                    padding: "20px",
                    boxShadow: "2px 2px 2px 1px rgba(0, 0, 0, 0.1)"
                }}>
                    <h3 style={{
                        fontWeight: "400",
                        textTransform: "uppercase"
                    }}>Dashboard</h3>
            </article>

            <article style={{
                    maxWidth: "1600px",
                    margin: "20px 0", 
                    borderRadius: "5px",
                    backgroundColor: "#f8f9f9",
                    padding: "20px",
                    boxShadow: "2px 2px 2px 1px rgba(0, 0, 0, 0.1)"
                }}>
                <h3>Titulo</h3>
                <p>Mussum Ipsum, cacilds vidis litro abertis.  Leite de capivaris, leite de mula manquis sem cabeça. Suco de cevadiss deixa as pessoas mais interessantis. Quem manda na minha terra sou euzis! Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl.</p>
                <p>Mauris nec dolor in eros commodo tempor. Aenean aliquam molestie leo, vitae iaculis nisl. Diuretics paradis num copo é motivis de denguis. Não sou faixa preta cumpadi, sou preto inteiris, inteiris. Tá deprimidis, eu conheço uma cachacis que pode alegrar sua vidis.</p>
                <p>Mais vale um bebadis conhecidiss, que um alcoolatra anonimis. Quem num gosta di mim que vai caçá sua turmis! Paisis, filhis, espiritis santis. Delegadis gente finis, bibendum egestas augue arcu ut est.</p>
                <p>In elementis mé pra quem é amistosis quis leo. Sapien in monti palavris qui num significa nadis i pareci latim. Leite de capivaris, leite de mula manquis sem cabeça. Admodum accumsan disputationi eu sit. Vide electram sadipscing et per.</p>
                <p>Detraxit consequat et quo num tendi nada. Delegadis gente finis, bibendum egestas augue arcu ut est. Sapien in monti palavris qui num significa nadis i pareci latim. Per aumento de cachacis, eu reclamis.</p>
            </article>
            
        </Content>
    );
}

export default Dashboard;