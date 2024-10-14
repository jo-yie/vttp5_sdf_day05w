import java.io.*;
import java.util.*;
import java.util.Map.Entry;

public class LanguageModel {
    private String fileName;
    private File file;
    private Map<String, Map<String, Integer>> outerMap;

    
    public LanguageModel(String fileName) {
        this.fileName = fileName;
        this.file = new File(fileName);

        // create outer map
        this.outerMap = new HashMap<>();

    }

    public void getHashMap() throws IOException {

        // new buffered reader 
        FileReader reader = new FileReader(file); 
        BufferedReader br = new BufferedReader((reader));

        String line;
        
        // read document line by line
        while ((line = br.readLine()) != null) { 

            // add words to list
            // using space to split words
            String[] words = line.split(" ");


            for (int i = 0; i < words.length - 1; i++) {
                String currWord = words[i];
                String nextWord = words[i+1];

                addWord(currWord, nextWord);
            }
            
        }

        // System.out.println(outerMap);

    }

    public void addWord(String current, String next) {
        
        // declare innermap
        Map<String, Integer> innerMap;

        // check if outermap contains current key
        if (outerMap.containsKey(current)) {
            innerMap = outerMap.get(current);
        } else {
            innerMap = new HashMap<>();
        }

        int count = 0;

        // check if innermap contains next key 
        if (innerMap.containsKey(next)) {
            count = innerMap.get(next);
        }

        // increment count 
        count ++; 

        // put into inner map 
        innerMap.put(next, count);

        // put into outer map 
        outerMap.put(current, innerMap);

    }

    public void getNextWord(String current) {

        // get current word from outer map 
        Map<String, Integer> temp;
        temp = outerMap.get(current);

        // get highest value in temp map 
        int maxValue = Collections.max(temp.values());

        String nextWord = "";

        // iterate through count in inner map 
        for (Entry<String, Integer> entry : temp.entrySet()) {
            if (entry.getValue() == maxValue) {
                nextWord = entry.getKey();
            }
        }

        // highest count = next word 
        System.out.println(nextWord);

    }

}
