import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class Main {
    public static void main(String[] args) {
        try {
            // Replace "path/to/your/input/file.txt" with the actual path to your input file
            String inputFilePath = "path/to/your/input/file.txt";

            // Create a FileReader to read the input file
            Reader reader = new FileReader(inputFilePath);

            // Create an instance of your LexicalAnalyzer
            LexicalAnalyzer lexer = new LexicalAnalyzer(reader);

            // Loop to get tokens until the end of the file
            while (true) {
                Symbol token = lexer.nextToken();

                // Check for the end of the file
                if (token.getType() == LexicalUnit.EOS) {
                    System.out.println("End of file reached.");
                    break;
                }

                // Print the token information
                System.out.println("Token: " + token.getType() + " | Value: " + token.getValue() +
                        " | Line: " + token.getLine() + " | Column: " + token.getColumn());
            }

            // Close the reader
            lexer.yyclose();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
