import "./styles.css"

function Aside() {
    return (
        <footer className="footer">
            <section>
                <h2 style={{fontWeight: 300}} >AdminBase</h2>
                <small>Development v1.0.0</small>
                <br />
                <br />
                <small><b>Flex ❤️ Grid</b></small>
            </section>

            <section>
                <ul style={{listStyle: "none", textAlign: "right"}}>
                    {/* <li><h3 style={{fontWeight: 400}} >Compartilhe</h3></li> */}
                    <li><a href="/">link1</a></li>
                    <li><a href="/">link2</a></li>
                    <li><a href="/">link3</a></li>
                </ul>
            </section>
        </footer>
    );
}

export default Aside;