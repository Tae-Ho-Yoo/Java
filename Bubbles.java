/**
 * Bubbles.java
 * Program finds a optimal path/value given a board of integers and a starting position
 * Part of Homework 6, Part 2
 * The total time complexity of the program is O(n)
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Bubbles
{
    static int score;
    static int[][] board;
    static int cnt;

    /**
     * function that sets up the memoization
     * @param row number of rows in board
     * @param col number of cols in board
     * @param startRow x location given for the starting balloon
     * @param startCol y location given for the starting balloon
     * @return the optimal solution
     */
    public static int bubbleMoney(int row, int col, int startRow, int startCol) {
        if (startRow < 0 || startCol >= col || startCol < 0){
            return 0;
        }
        if (startRow == 0){
            return board[0][startCol];
        }
        int[][] memo = new int[row][col];
        for (int i = 1; i < col; i++){
            memo[0][i] = board[0][i];
        }
        for (int i = 1; i < row; i++){
            memo[i][0] = board[i][0];
            memo[i][col-1] = board[i][col-1];
        }
        int maxLeft = 0;
        int maxRight = 0;
        int result = bubbleMoneyMemo(col, startRow, startCol, maxLeft, maxRight, memo);
        return result;
    }

    /**
     * Memoization of bubbleMoney
     * @param col number of cols in board
     * @param startRow x location given for the starting balloon
     * @param startCol y location given for the starting balloon
     * @param maxLeft counting value of left way
     * @param maxRight counting value of right way
     * @param memo the memory used for memoization
     * @return optimal solution
     */
    public static int bubbleMoneyMemo(int col, int startRow, int startCol, int maxLeft, int maxRight, int[][] memo){
        if (startCol == col){
            return memo[startRow][col-1];
        }
        if (startCol == 0){
            return memo[startRow][0];
        }
        if (startRow == 0){
            return memo[0][startCol];
        }
        memo[startRow][startCol] = bubbleMoneyMemo(col, startRow-1, startCol+1, maxLeft, maxRight, memo);
        maxRight = memo[startRow][startCol];
        memo[startRow][startCol] = bubbleMoneyMemo(col, startRow-1, startCol-1, maxLeft, maxRight, memo);
        maxLeft = memo[startRow][startCol];
        if (maxRight > maxLeft){
            int ansRight = board[startRow][startCol] + maxRight;
            return ansRight;
        }
        int ansLeft = board[startRow][startCol] + maxLeft;
        return ansLeft;    
        
    }

    
    public static void main(String [] args)
    {
	    if (args.length == 3){
            int startRow = Integer.parseInt(args[1]);
            int startCol = Integer.parseInt(args[2]);
            File myFile = new File(args[0]);
            Scanner scan = null;
            try {
                scan = new Scanner(myFile);
            } catch (FileNotFoundException e) {
                System.err.println("No file");
                System.exit(0);
            }
            String line = scan.nextLine();
            int numRows = Integer.valueOf(line.split(" ")[0]);
            int numCols = Integer.valueOf(line.split(" ")[1]);
            board = new int[numRows][numCols];
            for (int i = 0; i < numRows; i++){
                line = scan.nextLine();
                String[] boardLine = line.split(" ");
                for (int j = 0; j < boardLine.length; j++){
                    String numChar = boardLine[j];
                    board[i][j] = Integer.parseInt(String.valueOf(numChar));;
                }
            }
            System.out.println(bubbleMoney(numRows, numCols, startRow, startCol)); 
        }
    }
}
