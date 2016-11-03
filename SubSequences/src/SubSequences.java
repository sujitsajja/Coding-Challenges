import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Find all the sub strings possible for the given string in lexicographical order
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-10-31
 */

public class SubSequences {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string : ");
        String input = sc.next();
        ArrayList<String> subSequences = generateAllSubSequences(input);
        Collections.sort(subSequences);
        System.out.println("All the sub sequences formed by the given string are : "+subSequences);
    }
    
    /**
     * Function to generate all the sub sequences for the given string
     * @param input
     * @return All the possible sub sequences
     */
    private static ArrayList<String> generateAllSubSequences(String input) {
        ArrayList<String> result = new ArrayList<>();
        char[] possibleChars = input.toCharArray();
        recursiveHelper(result, possibleChars, 0, new StringBuilder());
        return result;
    }
    
    /**
     * Recursive function to find all the possible sub sequences
     * @param result
     * @param possibleChars
     * @param index
     * @param currentSubSequence 
     */
    private static void recursiveHelper(ArrayList<String> result, char[] possibleChars, int index, StringBuilder currentSubSequence) {
        if(index == possibleChars.length) {
            result.add(currentSubSequence.toString());
            return;
        }
        recursiveHelper(result, possibleChars, index+1, currentSubSequence);
        recursiveHelper(result, possibleChars, index+1, currentSubSequence.append(possibleChars[index]));
        currentSubSequence.setLength(currentSubSequence.length()-1);
    }
    
}

/**
 * Sample input:
 * abc
 * 
 * Sample output:
 * [, a, ab, abc, ac, b, bc, c]
 */