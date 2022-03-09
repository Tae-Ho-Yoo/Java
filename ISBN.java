/**
 * ISBN.java
 * A program for calculating the 13th and 10th digit of ISBN number.
 * Part of homework 1, problem 2
 */
import java.util.Scanner;

public class ISBN {
    public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
        boolean corrISBN = false;
        while (!corrISBN){
            System.out.println("Enter the ISBN");
            String isbn = scan.nextLine();
            if (ISBNNumisInt(isbn)){
                if (isbn.length() == 9){
                    int isbnInt = Integer.parseInt(isbn);
                    String tenthDig = isbn10(isbnInt);
                    System.out.println("Tenth digit is " + tenthDig);
                    corrISBN = true;
                } else if (isbn.length() == 12){
                    long isbnLong = Long.parseLong(isbn);
                    String thirteenthDig = isbn13(isbnLong);
                    System.out.println("Thirteenth digit is " + thirteenthDig);
                    corrISBN = true;
                } else {
                    System.out.println("Invalid ISBN");
                }
            } else {
                System.out.println("Invalid ISBN");
            }
        }   scan.close();
    }

    /**
     * checks if the user input is a character or integer.
     * @param ISBN user input taken from main
     * @return true if the input is integer and false for character.
     */
    public static boolean ISBNNumisInt(String ISBN){
        for (int i = 0; i < ISBN.length(); i++){
            if (!Character.isDigit(ISBN.charAt(i))){
                return false;
            }
        }
        return true;
    }
    
    /**
     * sample ISBN 019853453
     * 10th digit should be 1
     * @param isbn takes in the nine digit ISBN
     * @return 
     */
    public static String isbn10 (int isbn){
        int divident = 100000000;
        int singleDig = 0;
        int calcTenth = 0;
        for (int i = 1; i < 10; i ++)
        {
            singleDig = isbn/ divident;
            isbn = isbn - (singleDig * divident);
            calcTenth = calcTenth + (i * singleDig);
            divident = divident / 10;
        }
        calcTenth = calcTenth % 11;
        if (calcTenth == 10)
        {
            return ("X");
        } else
        {
            return Integer.toString(calcTenth);
        }
        

    }

    /**
     * Sample ISBN digit 978156619909
     * Thirteenth digit should be 4
     * @param isbn takes in the twelve ISBN
     * @return Thriteenth digit 
     */
    public static String isbn13 (long isbn){
        long divident = 100000000000L;
        long singleDig = 0L;
        long calcThirteenth = 0L;
        for (int i = 1; i < 13; i++)
        {
            singleDig = isbn/ divident;
            isbn = isbn - (singleDig * divident);
            if (i%2 == 0 && i != 1){
                calcThirteenth = calcThirteenth + (3*singleDig);
            } else{
                calcThirteenth = calcThirteenth + singleDig;
            }
            divident = divident / 10;
        }
        calcThirteenth = 10 - (calcThirteenth % 10);
        if (calcThirteenth == 10)
        {
            return "0";
        } else
        {
            return Long.toString(calcThirteenth);
        }
    }


}
