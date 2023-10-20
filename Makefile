RUN = mvn
TARGET_DIR = ./target
DOC_DIR = ./docs

.PHONY: build clean run build-docs clean-docs

all: build build-docs

build $(TARGET_DIR): pom.xml
	@printf "\e[33m%s\e[00m\n" "Building project..."
	@$(RUN) dependency:resolve
	@$(RUN) package

clean:
	@printf "\e[33m%s\e[00m\n" "Cleaning project directory..."
	@rm -rfv $(TARGET_DIR)
	
run: $(TARGET_DIR)
	@$(RUN) -q exec:java

build-docs:
	@printf "\e[33m%s\e[00m\n" "Building documentation..."
	@cd $(DOC_DIR); \
		for file in *.tex; do \
			printf "\e[34mFile:\e[00m %s\n" $${file}; \
			lualatex --halt-on-error --shell-escape $${file} && \
			lualatex --halt-on-error --shell-escape $${file}; \
		done

clean-docs:
	@printf "\e[33m%s\e[00m\n" "Cleaning documentation directory..."
	@rm -rfv $(DOC_DIR)/*.aux
	@rm -rfv $(DOC_DIR)/*.loc
	@rm -rfv $(DOC_DIR)/*.lof
	@rm -rfv $(DOC_DIR)/*.log
	@rm -rfv $(DOC_DIR)/*.toc
