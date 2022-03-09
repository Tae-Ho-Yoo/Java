/**
 * TextAnalytics.java
 * program that takes in a book and counts the occurences for each word then print the top 5 and user inputed word.
 * Homework 7
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextAnalytics {

    static Scanner scan = new Scanner(System.in);
    static final ObjectHashMap hash = new ObjectHashMap();

    /**
     * funciton reads the file 
     * @param textFile name of the book
     * The readFile function has the time complexity of O(n^2)
     */
    public static void readFile(File textFile){
        Scanner input = null;
        String text = "";
        String title = "";
        try {
            input = new Scanner(textFile);
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
            System.exit(0);
        }
        while (input.hasNextLine()){
            text = input.nextLine();
            text = text.toLowerCase();
            if (text.contains("title: ")){
                title = text.split(":")[1];
            }
            if (text.equals("*** start of the project gutenberg ebook" + title + " ***")){
                while (!text.equals("*** end of the project gutenberg ebook" + title + " ***")){
                    text = input.nextLine();
                    String[] wordList = new String[text.length()];
                    text = text.toLowerCase();
                    wordList = text.split("\\s+");
                    setHashMap(wordList);
                }
            }
        }
        input.close();
    }

    /**
     * function that sets up hash table
     * @param text the line that will be evaluated
     * setHashMap function has time complexity of O(n^2)
     */
    public static void setHashMap(String[] wordList){
        for (String word : wordList){
            word = word.replaceAll("[^a-z]", "");
            if (!word.equals("")){
                if (hash.containsKey(word)){
                    Entry existingEntry = hash.getEntry(word);
                    existingEntry.value = (Integer)existingEntry.value + 1;
                } else {
                    hash.put(word,1);
                }
            }
        }
    }

    /**
     * function that runs the program
     * runProgram function has time complexity of O(n)
     */
    public static void runProgram(){
        Object choice = "";
        while (!choice.equals("q")){
            System.out.println("Type a word or type q to quit");
            choice = scan.next();
            if (choice.equals("q")){
                System.out.println("Thanks for playing");
                choice = "q";
            } else {
                if (hash.containsKey(choice)){
                    System.out.println("The word " + "'" + choice + "'" + " occurs " + hash.find(choice) + " times");
                } else {
                    System.out.println("The word " + "'" + choice + "'" + " is not present");
                }
            } 
        }
    }

    /**
     * function prints out the top 5 most used words in a book
     * printTopFive function has time complexity of O(n^2)
     */
    public static void printTopFive(){
        Entry[] entryArr = hash.getEntries();
        insertionSort(entryArr);
        int cnt = 1;
        System.out.println("--Top 5 Most Frequent Words--");
        for (int i = entryArr.length-1; i > entryArr.length - 6; i--){
            System.out.println(cnt + ".) " + "'" + entryArr[i].key + "'" + "    " + hash.find(entryArr[i].key) + " uses.");
            cnt++;
        }
    }

    /**
     * function sorts the array from least to greatest
     * @param entryArr array of Entry
     * sortArr function has time complexity of O(n^2)
     */
    private static void insertionSort(Entry[] entryArr){
        for(int i = 1; i < entryArr.length; i++){
			Entry currEntry = entryArr[i];
            int j = i;
			while (j > 0 && (Integer)currEntry.value < (Integer)entryArr[j-1].value){
				entryArr[j] = entryArr[j-1];
                j--;
			}
            entryArr[j] = currEntry;
		}
    }
    public static void main(String[] args){
        File textFile = new File(args[0]);
        readFile(textFile);
        printTopFive();
        runProgram();
        scan.close();
    }
}
