# Documentação
Neste diretório, estão incluídos os arquivos relacionados a documentação completa e manual do sistema.

## Buildando os PDFs
Toda a documentação manual do projeto é feita em [LaTeX](https://www.latex-project.org). 
Portanto, é necessário compilar os arquivos `tex` para `pdf`.

É fortemente recomendado o uso do método automático, porém é possível compilar manualmente utilizando o `lualatex`

***Nota**: Ambos os métodos assumem que o usuário está no diretório raiz do projeto.*

### Automático - Makefile (Recomendado)
Utilize o `make`:
```bash
make build-docs
```
*Opcionalmente, limpe os arquivos auxiliares com `make clean-docs`*

### Manualmente - LuaLatex
Utilize o `lualatex`, habilitando comandos para o shell, compilando duas vezes para garantir que os arquivos auxiliares existam:
```bash
cd docs/
lualatex --halt-on-error --shell-escape *.tex
lualatex --halt-on-error --shell-escape *.tex
cd -
```
