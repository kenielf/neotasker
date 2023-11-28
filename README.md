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
mvn dependency:resolve
mvn package
mvn -q exec:java
```

## Documentação
Mais informações sobre a documentação é acessível [aqui](/docs)

## Versionamento - Estrutura e Linha do Tempo
### Guia
Esse software é versionado a partir do esquema de [Versionamento Numérico-Semantico](https://en.wikipedia.org/wiki/Software_versioning#Semantic_versioning). Mais específicamente, a versão do software é definida da seguinte maneira:
**`[MAJOR].[MINOR].[PATCH]`**
 - **Major:** Lançamentos;
 - **Minor:** Mudanças Significativas ao Comportamento do Software;
 - **Patch:** Mudanças Pequenas ou Hotfixes;

### Versões
 - **0.1**: Código Inicial:
   - Configuração do Maven;
   - Configuração do Repositório.

 - **0.2**: Gerenciamento do Sistema Operacional:
   - Caminho de Arquivos e Pastas;
   - Uso de Cores em Saídas de Texto.

 - **0.3**: Configuração do ORM e Gerenciamento de Banco de Dados:
   - Configuração do Hibernate;
   - Modelos de Dados Iniciais.

 - **0.4**: Tela Inicial:
   - Barra de Navegação;
   - Painel de Conteúdo Vazio.

 - **0.5**: Gerenciamento de Configuração:
   - Criação, Leitura e Atualização de Configuração;
   - Opções:
     - Escala da Interface;
     - Tema da Interface;
     - Tema dos Ícones;
     - Modo de Antiserrilhamento.

 - **0.6**: Tela de Configuração:
   - Modificação Interativa de Configurações.

 - **0.7**: Tela de Tarefas:
   - Ampliagem do Modelo de Dados;
   - Listagem, Adição e Modificação de Tarefas;
   - Pesquisa e Filtragem de Tarefas.

 - **0.8**: Tela de Estatísticas:
   - Adição do Modelo de Dados de Estatísticas;
   - Listagem de Dados Estatísticos.

 - **0.9**: Calendário:
   - Interação com Datas Específicas.

 - **1.0**: Lançamento:
   - Polimento de Código.

