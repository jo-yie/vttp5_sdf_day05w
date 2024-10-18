import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        // default first word
        String firstWord = "I";

        // default file 
        String filePath = "data/austen.txt";

        // number of words to be generated 
        int numWords = 1; 

        // user input file name + first word 
        if (args.length > 0) {
            firstWord = args[0];
            filePath = args[1];
            numWords = Integer.parseInt(args[2]);
        }

        // instantiate new model 
        LanguageModel test = new LanguageModel("data/" + filePath);

        // get HashMap 
        test.getHashMap();

        // create array for sentence
        List<String> temp = new ArrayList<>(); 

        // firstWord as first value in array 
        temp.add(firstWord);

        // get next word for numWords 
        for (int i = 0; i < numWords; i++) {
            String nextWord = test.getNextWord(firstWord);
            temp.add(nextWord);
            firstWord = nextWord;
        }

        // print all words as sentence
        for (String s : temp) {
            System.out.printf("%s ", s);
        }

        // System.out.println("complete");

    }

}
