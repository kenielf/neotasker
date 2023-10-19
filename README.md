# NeoTasker
Aplicativo de Gerenciamento de Agenda Pessoal
<!--- Inserir uma logo aqui, caso seja criada --->

## Membros
 - [Chrystian *"kenielf"* M. Franklin](https://github.com/kenielf/test)
 - [Welligton *"dablio"* E. Rodrigues](https://github.com/Dablio-0)

## Preparando o Projeto
Primeiramente, clone o repositório e navegue até seu diretório raíz:
```bash
git clone https://github.com/kenielf/neotasker.git
cd neotasker
```

## Buildando e Executando
Há duas maneiras de buildar e executar o projeto: **automática** e **manual**.

### Automático - Makefile (Recomendado)
Utilize os scripts disponíveis pelo `make`:
```bash
make build
make run
```

### Manual - Maven
Então, builde o projeto e o execute com o `mvn`:
```bash
mvn package
mvn -q exec:java
```

## Documentação
Mais informações sobre a documentação é acessível [aqui](/docs)
