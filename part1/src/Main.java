import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    private static final String USAGE_MESSAGE = "Usage: java -jar part1.jar file.pmp\n" +
            "or\tjava LexicalAnalyzerApp file.pmp";

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println(USAGE_MESSAGE);
            return;
        }

        processFile(args[0]);
    }

    private static void processFile(String filePath) {
        try (FileReader source = new FileReader(filePath)) {
            LexicalAnalyzer analyzer = new LexicalAnalyzer(source);
            TreeMap<String, Symbol> variableSymbols = new TreeMap<>();
            Symbol currentSymbol;

            while (!((currentSymbol = analyzer.nextToken()).getType() == LexicalUnit.EOS)) {
                System.out.println(currentSymbol);
                addVariableIfNecessary(currentSymbol, variableSymbols);
            }

            printVariables(variableSymbols);
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + filePath);
        } catch (IOException e) {
            System.err.println("An I/O error occurred: " + e.getMessage());
        }
    }

    private static void addVariableIfNecessary(Symbol symbol, Map<String, Symbol> variables) {
        if (symbol.getType() == LexicalUnit.VARNAME) {
            variables.putIfAbsent(symbol.getValue().toString(), symbol);
        }
    }

    private static void printVariables(Map<String, Symbol> variables) {
        System.out.println("\nVariables");
        variables.forEach((name, symbol) -> System.out.println(name + "\t" + symbol.getLine()));
    }
}
