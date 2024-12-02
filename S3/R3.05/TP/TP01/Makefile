# Convention : Les fichiers de suffixe .c
#              - contiennent un main()
#              - sont les seuls à contenir un main()
#              - et donnent lieu à un exécutable de même nom (sans le suffixe) dans les répertoires bin-gcc/ et bin-clang/
#
# Exemples de compilation :
# make
# make ETU=y
# make OPT=non
#
# Exemples d'exécution :
# bin-gcc/mon_executable
# bin-clang/mon_executable

ifeq ($(OPT),non)
OPTFLAGS=-O0
else
OPTFLAGS=-O2
endif

DEFINES = -D_GNU_SOURCE # for sched_setaffinity() sched_getcpu()

ifeq ($(ETU),y)
DEFINES += -DETUDIANTS
endif

compilo-gcc = gcc $(OPTFLAGS) -g -std=gnu11 -Wall -W -Werror
compilo-clang = clang $(OPTFLAGS) -g -std=gnu11 -Wall -Wextra -Werror -Wno-declaration-after-statement -Wno-missing-noreturn -Wno-padded -Wno-disabled-macro-expansion -fcaret-diagnostics

executables = $(patsubst %.c,%,$(wildcard *.c))

executables-gcc = $(foreach exe,$(executables),bin-gcc/$(exe))
executables-clang = $(foreach exe,$(executables),bin-clang/$(exe))

default: $(executables-gcc)

$(executables-gcc): %: %.o
	@make --no-print-directory $(subst bin-gcc,bin-clang,$@)
	$(compilo-gcc) $^ -o $@

$(executables-clang): %: %.o
	$(compilo-clang) $^ -o $@

bin-gcc/%.o: %.c
	@mkdir -p bin-gcc
	@make --no-print-directory $(subst bin-gcc,bin-clang,$@)
	$(compilo-gcc) $(DEFINES) -c $< -o $@

bin-clang/%.o: %.c
	@mkdir -p bin-clang
	$(compilo-clang) $(DEFINES) -c $< -o $@

menage:
	rm -rf *~ bin* a.out core

