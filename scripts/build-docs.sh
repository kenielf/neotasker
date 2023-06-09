#!/usr/bin/env sh
# shellcheck disable=SC2034  # NOTE: Unused vars are kept for consistency.
# <!--- Preamble: Functions --->
# Prints a fatal error message with a colored indicator by default, 
# message is an argument, but exit code and indicator can be overwritten.
error() {
    # Mandatory message argument
    if [ -z "${1}" ]; then
        error "Função interna 'error' requer um argumento!"
    fi

    # Print error message
    printf "${RED}${E_INDICATOR}${RST} %b\n" "${1}"

    # Exit if fatal
    if ! [ "${E_CODE}" = 0 ]; then
        exit "${E_CODE}"
    fi
}

# Prints a debug message if the environment variable is set
debug() {
    # Check for debug env var
    if [ "${DEBUG}" = "1" ] || [ "${DEBUG}" = true ]; then
        # Mandatory message argument
        if [ -z "${1}" ]; then
            error "Função interna 'debug' requer um argumento!"
        fi

        printf "${CYN}${D_INDICATOR}${RST} %b\n" "${1}"
    fi
}


# Removes the auxiliary files for a given texfile
rm_aux() {
    debug "Removendo arquivos auxiliares..."
    basename="$(
        echo "${file}" | awk -F '/' '{print $NF}' | sed -e 's/.tex//g'
    )"

    for ext in ${REMOVABLE_EXT}; do
        rm -rv "${PROJ_ROOT}/${DOC_DIR}/${basename}.${ext}" 2>/dev/null
    done
}

# <!--- Preamble: Constants / Defaults --->
# Default Error Constants
E_CODE=1
E_INDICATOR="[ERRO]"

# Debug
D_INDICATOR="[DEBUG]"

# Colors
DISABLE_COLOR=false

# Remove auxiliary file types
REMOVABLE_EXT="aux idx ilg ind toc log"

# Documentation Directory
DOC_DIR="docs"

# <!--- Preamble: Variables --->
# Set debug to false if no flags were passed
[ -z "${DEBUG}" ] && DEBUG=false

# Colors
if [ -n "${NO_COLOR}" ] || [ "${DISABLE_COLOR}" = true ]; then
    # Disable Colors
	RST=''
	BLK=''
	RED=''
	GRN=''
	YLW=''
	BLU=''
	MGT=''
	CYN=''
	WHT=''
else
	RST='\e[0m'
	BLK='\e[30m'
	RED='\e[31m'
	GRN='\e[32m'
	YLW='\e[33m'
	BLU='\e[34m'
	MGT='\e[35m'
	CYN='\e[36m'
	WHT='\e[37m'
fi

# <!--- Runtime: Main --->
# TODO: Make sure user is not root
debug "Verificando id do usuário..."
SUID="$(id -u 2>/dev/null)"
if [ "${SUID}" = "0" ]; then
    error "Usuário não deve ser root!"
fi

# Make sure that the necessary command to compile exists
if ! command -v lualatex >/dev/null 2>&1; then
    error "Programa 'lualatex' ausente! Verifique-o e tente novamente."
fi

# Make sure that the user is in the project directory
debug "Verificando se o repositório git existe..."
if ! git status >/dev/null 2>&1; then
    error "Raiz do repositório não encontrada! Verifique-o e tente novamente."
fi
PROJ_ROOT="$(git rev-parse --show-toplevel 2>/dev/null)"

# Compile every '.tex' file in the doc directory
for file in "${PROJ_ROOT}/${DOC_DIR}"/*.tex; do
    basename="$(
        echo "${file}" | awk -F '/' '{print $NF}' | sed -e 's/.tex//g'
    )"

    # Build document twice, to account for necessary auxiliary files.
    debug "Compilando '${file}'..."
    cd "${PROJ_ROOT}/${DOC_DIR}" && \
        lualatex --interaction=errorstopmode --shell-escape --draftmode "${file}" && \
        lualatex --interaction=errorstopmode --shell-escape "${file}"

    # Remove extra auxiliary files
    rm_aux
done
