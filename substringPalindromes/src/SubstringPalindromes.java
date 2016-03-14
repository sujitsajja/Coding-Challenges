import java.util.HashSet;
import java.util.Scanner;

/**
 * Find the number of palindromic substrings that
 * can be formed from the given string
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-14
 */

public class SubstringPalindromes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string for which you want "
                + "to find the number of palindromic substrings : ");
        String input = sc.next();
        System.out.println("Number of substring palindromes present "
                + "in the given input are : "+substringPalindromes(input));
    }

    /**
     * Function to find the number of substring palindromes
     * 
     * @param input String
     * 
     * @return number of substring palindromes
     */
    private static int substringPalindromes(String input) {
        // To check for duplicate palidromes we store them in hashset
        HashSet<String> palindromes = new HashSet<>();
        for(int i=0;i<input.length();i++){
            // For palidromes with odd length
            checkPalindrome(input,i,i,palindromes);
            // For palidromes with even length
            checkPalindrome(input,i,i+1,palindromes);
        }
        return palindromes.size();
    }

    /**
     * Function to check if the current substring is a palindrome
     * 
     * @param input String
     * @param i start index of the substring
     * @param j end index of the substring
     * @param palindromes List of palindromes found till now
     */
    private static void checkPalindrome(String input, int i, int j, HashSet<String> palindromes) {
        while(i>=0 && j<input.length()){
            if(input.charAt(i)==input.charAt(j)){
                palindromes.add(input.substring(i, j+1));
                i--;
                j++;
            }
            else
                break;
        }
    }

}

/**
 * Sample input:
 * abcbabcbabcba
 * 
 * Sample output:
 * 13
 */