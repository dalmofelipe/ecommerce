# SpringReact Ecommerce Systems (WiP)

Projeto Fullstack de um sistema de loja online (Ecommerce).

E um projeto pessoal, para prática e demonstração meus conhecimentos em desenvolvimento de aplicações web, aplicando arquitetura em microsserviços, utilizando Spring Boot e React.

Inicialmente será implementado:

- Frontend da área Administrativa (Dashboard)
- Microserviço para gerenciamento de estoque, produtos, categorias, fornecedores (StockMicroSrvc)
- Microserviço para gerenciamento da loja (EcommerceMicroSrvc)
- Frontend da Loja (Ecommerce)
- Microserviço para gerenciamento de identidades (IdMicroSrvc)
- Serviço Fake de Pagamentos (FakePaymentGateway)

Ainda não possuo experiência profissional como desenvolvedor, qualquer dica ou sugestão, será super bem vinda!

---

## Executando

Projeto é monorepo, basta clonar este repositorio e seguir as orientações. Ferramentas necessárias:

- Java 17+
- Node 18+
- Maven / NPM / Yarn
- Docker

Em breve, tudo será containerizado e executado via docker-compose.

```sh
git clone https://github.com/dalmofelipe/ecommerce

cd ecommerce

tree -L 2 .

.
├── backend
│   └── StockMicroSrvc
├── docker
│   └── mysql
├── docker-compose.yaml
├── README.md
└── webapp
    └── Admin
```


### Banco de Dados MySQL com docker-compose

```sh
# na raiz do projeto (pasta ecommerce)
docker compose up -d
```

Acesse http://localhost:5000 para visualizar interface para MySQL, informe os dados:

```
Sistema	        : MySQL
Servidor	    : mysqldb-docker
Usuário	        : root
Senha	        : root
Base de dados   : ecommerce_stock
```

### Frontend Administrativo (Dashboard)

```sh
cd webapp/Admin

# crie o .env com variaveis de ambiendo do .env-example
touch .env

# somente na primeira vez
yarn install

yarn start
```

### Microserviço para gerenciamento de Estoque (StockMicroSrvc)

```sh
cd backend/StockMicroSrvc

./mvnw spring-boot:run
```

<br>

Acesse http://localhost:3000 para ir a Dashboard Administrativa
