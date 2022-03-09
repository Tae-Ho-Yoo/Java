/**
 * ReadFEN.java
 * A program that converts a single line of FEN number into 2d format
 * Homework 2
 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.lang.StringBuilder;
public class ReadFEN {
    
    private static final String numStr = "12345678";
    private static final String pieceStr = "pnbrqkPNBRQK";

    /**
     * checks if length is 8
     * @param boardArr FEN number made into array
     * @return true if there are 8 false if there isnt
     */
    private static boolean checkRows(char[] boardArr){
        int lenRow = 0;
        for (int i =0; i <= boardArr.length-1; i++){
            if (boardArr[i] == '/'){
                lenRow++;
            }
        }
        return (lenRow == 8);
    }

    /**
     * checks if there are no extraneous characters
     * @param boardArr FEN number made into array
     * @return true if there are no extraneous character false if there are
     */
    private static boolean checkPiece(char[] boardArr){
        for (int i = 0; i < boardArr.length; i++){
            if (pieceStr.indexOf(boardArr[i]) != -1 && numStr.indexOf(boardArr[i]) != -1){
                return false;
            } 
        }
        return true;
    }

    /**
     * checks if there are no number characters together
     * @param boardArr FEN number made into array
     * @return true if there are no number characters together false if there are
     */
    private static boolean checkConsNum(char[] boardArr){
        for (int i = 0; i < boardArr.length-1; i++){
            if (numStr.indexOf(boardArr[i]) > -1 && numStr.indexOf(boardArr[i+1]) > -1){
                return false;
            } 
        }
        return true;
    }

    /**
     * checks if the row contains 8squares worth of information
     * @param boardArr FEN number made into array
     * @return true if checkCond is 8 false if checkCond doesnt equal 8
     */
    private static boolean checkValRows(String boardStr){
        int infoWorthFen = 0;
        int infoWorthRow = 0;
        String[] checkArr = boardStr.split("/");
        for (String row : checkArr){
            for (int i = 0; i < row.length(); i++){
                if (pieceStr.indexOf(row.toCharArray()[i]) > -1){
                    infoWorthRow++;
                } else if (numStr.indexOf(row.toCharArray()[i]) > -1){
                    infoWorthRow = infoWorthRow + Integer.parseInt(String.valueOf(row.toCharArray()[i]));
                }
                if (infoWorthRow == 8){
                    infoWorthFen++;
                    infoWorthRow = 0;
                }
            }
        }
        
        return (infoWorthFen == 8);
    }

    /**
     * runs if there are no command line arguments
     * @return the FEN number entered from the user
     */ 
    private static String takeUserInput(){
        System.out.println("Enter the FEN");
        Scanner scan = new Scanner(System.in);
        String boardStr = scan.next();
        scan.close();
        return boardStr;
    }

    /**
     * runs if there are command line arguments
     * @param inputFile the file that is inputing FEN to the system
     * @return the FEN number on the file
     */
    private static String turnFile(String inputFile){
        File fenFile = new File(inputFile);
        Scanner input = null;
        try {
            input = new Scanner(fenFile);
        } catch (FileNotFoundException e) {
            System.out.println("File doesn't exist");
            System.exit(0);
        }
        String rowFen = input.nextLine();
        input.close();
        return rowFen;
        }
    
    /**
     * checks if the FEN number is valid
     * @param boardArr array of characters from the string of the user input
     * @param fenBoard string of the user input
     * @return true if the FEN number is valid and false if its not
     */
    private static boolean checkFen(char[] boardArr, String fenBoard){
        if (checkRows(boardArr) && checkPiece(boardArr) && checkConsNum(boardArr) && checkValRows(fenBoard)){
            return true;
        }
        return false;
    }

    /**
     * turns the string into 2d board format
     * @param fenBoard string user input
     * @return the 2d board format of the string
     */
    public static String turnBoard(String fenBoard){
        char[] boardArr = fenBoard.toCharArray();
        boolean validFen = checkFen(boardArr, fenBoard);
        StringBuilder outputBoard = new StringBuilder();
        if (validFen){
            String[] gameBoard = fenBoard.split("/");
            for (String board : gameBoard){
                for (int i = 0; i < board.length(); i++){
                     if (numStr.indexOf(board.toCharArray()[i]) > -1){ 
                        outputBoard.append(".".repeat(Integer.parseInt(String.valueOf(board.toCharArray()[i]))));
                    } else{
                        outputBoard.append(board.toCharArray()[i]);
                    }
                }
                outputBoard.append('\n');
            }
            return outputBoard.toString();
        }
        return "invalid";
    }

    
    public static void main(String[] args){
        String fenBoard ="";
        if (args.length != 0){
            String inputFile = args[0];
            String outputFile = args[1];
            fenBoard = turnFile(inputFile);
            String newBoard = turnBoard(fenBoard);
            if (newBoard.equals("invalid")){
                System.out.println("Invalid FEN");
            } else {
                File fenFile = new File(outputFile);
                PrintStream outBoard = null;
                try {
                    outBoard = new PrintStream(fenFile);
                    outBoard.print(newBoard);
                } catch (FileNotFoundException e) {
                    System.err.println("No file found");
                    System.exit(0);
                }
                outBoard.close();    
            }
        } else {
            fenBoard = takeUserInput();
            String newBoard = turnBoard(fenBoard);
            if (newBoard.equals("invalid")){
                System.out.println("Invalid FEN");
            } else {
            System.out.println(newBoard);
            }
        }
    }
}
    

