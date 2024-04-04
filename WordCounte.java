Q3:Write a Java Program to count the number of words in a string using HashMap.
  
Solution :
  
import java.util.HashMap;
public class WordCounter {
    public static HashMap<String, Integer> countWords(String sentence) {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        String[] words = sentence.split("\\s+");

        for (String word : words) {
            word = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
            if (!word.isEmpty()) {
                wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
            }
        }
        return wordCountMap;
    }
    public static void main(String[] args) {
        String sentence = "Hello world! This is a Java program to count the number of words in a string. Hello Java world!";
        HashMap<String, Integer> wordCountMap = countWords(sentence);
        System.out.println("Word Counts:");
        for (String word : wordCountMap.keySet()) {
            System.out.println(word + ": " + wordCountMap.get(word));
        }
    }
}
