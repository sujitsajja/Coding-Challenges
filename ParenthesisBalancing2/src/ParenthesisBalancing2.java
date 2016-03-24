import java.util.Scanner;

/**
 * To check if the given order of parenthesis is balanced or not
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-24
 */

public class ParenthesisBalancing2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Parenthesis to be checked for balance : ");
        String input = sc.next();
        if(isBalanced(input))
            System.out.println("The given parenthesis is balanced");
        else
            System.out.println("The given parenthesis is not balanced");
    }

    /**
     * Function to check if the given parenthesis is balanced or not
     * 
     * @param input String representation of parenthesis
     * 
     * @return True : If the parenthesis is balanced
     *         False: If the parenthesis is not balanced
     */
    private static boolean isBalanced(String input) {
        int length = input.length();
        // If the length of the string is odd then we can say
        // for sure that the parenthesis is not balanced
        if(length%2!=0)
            return false;
        // Maintaining a count of currently opened parenthesis
        int count = 0;
        for(int i=0;i<length;i++){
            Character current = input.charAt(i);
            // If the current char is an open parenthesis
            // then we increment the count
            if(current.equals('('))
                count++;
            // If the current char is a close parenthesis
            // then we decrement the count
            else
                count--;
            // If the count is less than zero then it is not balanced
            if(count<0)
                return false;
        }
        return (count==0);
    }

}

/**
 * Sample input:
 * ()()()(()())
 * 
 * Sample output:
 * Balanced
 */