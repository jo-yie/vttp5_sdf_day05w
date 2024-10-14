import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        String firstWord = "I";

        if (args.length > 0) {
            firstWord = args[0];
        }

        LanguageModel test = new LanguageModel("data/austen.txt");

        test.getHashMap();
        test.getNextWord(firstWord);

        System.out.println("complete");

    }

}
