/**
 * GuessingGame.java
 * The program makes a random and asks the user to correctly guess the number.
 * Part of homework 1, part 1
 */
import java.util.Random;
import java.util.Scanner;

public class GuessingGame {

    static Scanner scan = new Scanner(System.in);
    static Scanner scan1 = new Scanner(System.in);

    /**
     * decides whether the condition is met to end the game
     * @param choice variable to determine to end the game or keep playing
     * @return true to end the game and false to keep playing
     */
    private static boolean gameQuit (String choice)
    {
        if (choice.equals("q") || choice.equals("n"))
        {
            return true;
        }
        return false;
    }

    /**
     * decides if the user input is valid
     * @param guess user input
     * @return true if the input is valid and false if its not
     */
    private static boolean inputValid (String guess){
        if (!guess.equals("q")){
            for (char nextChar : guess.toCharArray()){
                if (!Character.isDigit(nextChar)){
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * decides if the number was correct
     * @param ranNum randum number created by the program
     * @param guessNum number guessed from the user
     * @return true if they match and false if they don't
     */
    private static boolean numCorrect (int ranNum, int guessNum)
    {
        if (guessNum == ranNum)
        {
            return true;
        }
        return false;
    }

    /**
     * decides if the guess was greater or less than the random number
     * @param guessNum number guessed by user
     * @param ranNum number created by the game
     * @return true if user guess was greater and false if its not
     */
    private static boolean guessGreater (int guessNum, int ranNum){
        if (guessNum > ranNum)
        {
            return true;
        } else {
            return false;
        }
    }

    /**
     * function that runs the game
     * @param guess user input that runs the game
     * @param ranNum nuber created by the system
     * @param cnt variable that counts number of tries
     * @return gamefinish to determine whether to end the program or not in main function.
     */
    private static boolean gamePlay (String guess, int ranNum, int cnt){
        Random rand2 = new Random();
        boolean gameFinish = false;
        System.out.println("Please guess a number from 1-100 or q to quit");
        guess = scan.nextLine();
        while (inputValid(guess))
            {
                if (gameQuit(guess))
                {
                    System.out.println("Thanks for playing");
                    System.out.println("The mystery number was " + ranNum);
                    gameFinish = true;
                    scan1.close();
                    scan.close();
                    return gameFinish;
                } else 
                {
                    int guessNum = Integer.parseInt(guess);
                    if (numCorrect(ranNum, guessNum))
                    {
                        System.out.print("That's correct.");
                        System.out.println(" It took you " + cnt + " tries");                
                        System.out.println("Would you like to play again?(y/n)");
                        String gameChoice = scan1.nextLine();
                        if (gameQuit(gameChoice))
                        {
                            gameFinish = true;
                            System.out.println("Thanks for playing");
                            scan1.close();
                            scan.close();
                            return gameFinish;
                        } else{
                        ranNum = rand2.nextInt(100)+1;
                        cnt = 1;
                        System.out.println("Please guess a number from 1-100 or q to quit");
                        guess = scan.nextLine();
                        }
                    } else 
                    {
                        System.out.print("That's incorrect");
                        if (guessGreater(guessNum,ranNum)){
                            System.out.println(" guess was too high");
                        } else{
                            System.out.println(" guess was too low");
                        }
                        System.out.println("Please guess a number from 1-100 or q to quit");
                        guess = scan.nextLine();
                        cnt++;
                    }
                }
            }
            return gameFinish;
        }
    public static void main (String [] args)
    {
        String guess = "";
        boolean gameFinish;
        int cnt = 1;
        boolean game = true;
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        int ranNum = rand.nextInt(100)+1;
        while (game)
        {
            gameFinish = gamePlay(guess, ranNum, cnt);        
            if (gameFinish){
                game = false;
            } 
        }
        scan.close();
        scan1.close();       
    }
}

    
        
        
       



        
        




