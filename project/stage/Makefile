#
GNAME= ul
GSRC= $(GNAME).g

all: grammar compiler

grammar: $(GSRCS)
	java org.antlr.Tool -fo . $(GSRC)

compiler:
	javac *.java AST/*.java Type/*.java IR/*.java

clean:
	rm *.class AST/*.class Type/*.class IR/*.class $(GNAME)*.java $(GNAME)__.g $(GNAME).tokens
