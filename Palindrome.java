/**
 * Palindrome.java
 * program finds whether a string is a palindrome
 * Part of Homework 6, Part 1
 * The edge cases for the problem is the strings with length of 1
 * The total time complexity of the program is O(n)
 */
class Palindrome
{

    /**
     * helper recursive function that finds palindrome
     * @param s string being evaluated
     * @param head index of first item
     * @param tail index of last item
     * @return true if string is palindrome and false if its not
     */
    private static boolean isPalindromeRec(String s, int head, int tail)
    {
        if (head == tail || head > tail){
            return true;
        }
        char firstChar = s.charAt(head);
        char secondChar = s.charAt(tail);
        if (firstChar != secondChar){
            return false;
        } 
        else {
            return isPalindromeRec(s, head+1, tail-1);
        }
        
    }

    /**
     * function that calls helper function to see if string is a palindrome
     * @param s string given
     * @return true if string is palindrome false if its not
     */
    public static boolean isPalindrome(String s){
        int head = 0;
        int tail = s.length()-1;
        return isPalindromeRec(s, head, tail);
    }

    public static void main(String [] args)
    {
    String s = args[0].toLowerCase();
    boolean res = isPalindrome(s); 
    if (res){
        System.out.println(s + " is a palindrome");
    }
    else
        System.out.println(s + " is not a palindrome");
    }
}
