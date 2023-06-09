# NeoTasker
Agenda Pessoal

## Documentação
Para compilar os arquivos de documentação presentes em `/docs` para `pdf`, 
garanta que as dependências das bibliotecas comuns de LaTeX estejam presentes, 
com o comando `lualatex --version` retornando sua versão do `LuaHBTex`.

Então, utilize o seguinte comando a partir do diretório raíz do repositório:
```bash
./scripts/build-docs.sh
```
Opcionalmente utilize essas variáveis de ambiente para maior customização:
 - `DEBUG=1`: Printa mensagens de depuração auxiliares.
 - `NO_COLOR=1`: Desabilita a saída de cores, para *dumb terminals*.
