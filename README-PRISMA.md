# Postgres local com Docker + Prisma (rápido)

Este guia cria um Postgres local via Docker e configura Prisma para gerenciar migrations do schema do banco.

1) Pré-requisitos
- Docker e Docker Compose
- Node.js (para rodar as ferramentas do Prisma)

2) Variáveis de ambiente
- Há um arquivo `.env.db` na raiz com credenciais. Para usá-lo:

  No PowerShell:

  ```powershell
  # carrega variáveis do .env.db na sessão
  Get-Content .\.env.db | ForEach-Object { $name, $value = $_ -split "=",2; if($name){ setx $name $value } }
  ```

  Alternativamente, exporte manualmente `POSTGRES_USER`, `POSTGRES_PASSWORD`, `POSTGRES_DB`.

3) Subir o Postgres + pgAdmin

```powershell
docker compose up -d
```

4) Instalar dependências do Prisma

```powershell
cd prisma
npm install
```

5) Gerar cliente Prisma e criar a primeira migration

```powershell
# Gera o cliente
npm run prisma:generate

# Cria e aplica migration de desenvolvimento (irá criar tabelas no DB docker)
npm run migrate:dev

# Abrir Prisma Studio
npm run studio
```

6) Conectar Spring Boot ao DB

Atualize `src/main/resources/application.properties` para usar a URL:

spring.datasource.url=jdbc:postgresql://localhost:5432/ludicom?sslmode=disable
spring.datasource.username=dev
spring.datasource.password=devpass

Isso evita problemas de SSL; se quiser `verify-full` você terá que configurar `root.crt`.

7) Observações
- Não comite credenciais sensíveis. `.env.db` é para uso local/dev. Para CI/produção, use segredos.
