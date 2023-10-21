# Default target
all: jflex compile test_euclid
tests: test_euclid test_arithmetic_operators test_basic_keywords_and_Operators test_boolean_operators_and_comparison test_comments test_error_scenarios test_loops
# Generate the Lexer Java class from the JFlex specification
jflex:
	jflex -d src src/LexicalAnalyzer.flex

# Compile the Java classes
compile:
	javac -d . src/*.java

# Run the test
test_euclid:
	cd src && java Main ../euclid.pmp

test_arithmetic_operators:
	cd src && java Main ../test/Aritmetic_Operators.pmp

test_basic_keywords_and_Operators:
	cd src && java Main ../test/Basic_Keywords_and_Operators.pmp

test_boolean_operators_and_comparison:
	cd src && java Main ../test/Boolean_Operators_and_Comparison.pmp

test_comments:
	cd src && java Main ../test/Comments.pmp

test_error_scenarios:
	cd src && java Main ../test/Error_Scenarios.pmp

test_loops:
	cd src && java Main ../test/Loops.pmp

# Clean compiled files
clean:
	rm -f src/*.class
