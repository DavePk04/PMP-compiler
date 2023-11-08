
default: build

jflex:
	jflex src/LexicalAnalyzer.flex

build: jflex
	javac -d more -cp src/ src/Main.java
	jar cfe dist/part1.jar Main -C more .
	javadoc -private src/*.java -d doc/javadoc

testing:
	for testFile in test/*.pmp ; do \
		echo "\nTest file:" $$testFile ; \
		java -jar dist/part1.jar $$testFile ; \
		echo "" ; \
	done

all: build testing
