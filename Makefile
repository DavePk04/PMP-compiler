# variables
JFLAGS = -g
JC = javac
JAR = jar cfe
JFLEX = jflex
JDOC = javadoc
SRC = ./src
DOC = ./doc
DIST = ./dist
TEST = ./test

# make target
all: jar javadoc

# compile the java files
compile: $(SRC)/LexicalAnalyzer.flex $(SRC)/*.java
	$(JFLEX) $<
	$(JC) $(JFLAGS) -d $(DIST) -cp $(SRC) $(SRC)/*.java

# create the jar file
jar: compile
	$(JAR) $(DIST)/part1.jar Main -C $(DIST) .

# create the javadoc
javadoc:
	$(JDOC) -d $(DOC) $(SRC)/*.java

# run the test (test1.pmp); you can change the test file name
test: jar
	java -jar $(DIST)/part1.jar $(TEST)/test1.pmp

# clean the compiled files and doc
clean:
	rm -rf $(SRC)/*.class $(DOC)/* $(DIST)/*.jar $(DIST)/*.class

# Phony targets
.PHONY: all compile jar javadoc test clean
