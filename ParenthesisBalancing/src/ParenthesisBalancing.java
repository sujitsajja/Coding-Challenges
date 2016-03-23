import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * To check if the given order of parenthesis is balanced or not
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-21
 */

public class ParenthesisBalancing {

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
        if(length%2!=0)
            return false;
        ArrayDeque<Character> openParenthesis = new ArrayDeque<>();
        Character openBracket = '(';
        Character openSquare = '[';
        Character openFlower = '{';
        Character closeBracket = ')';
        Character closeSquare = ']';
        Character closeFlower = '}';
        for(int i=0;i<length;i++){
            Character current = input.charAt(i);
            if(current.equals(openBracket) || 
                    current.equals(openFlower) || 
                    current.equals(openSquare))
                openParenthesis.push(current);
            else{
                if(current.equals(closeBracket)){
                    if(!openParenthesis.pop().equals(openBracket))
                        return false;
                }
                else if(current.equals(closeFlower)){
                    if(!openParenthesis.pop().equals(openFlower))
                        return false;
                }
                else if(current.equals(closeSquare)){
                    if(!openParenthesis.pop().equals(openSquare))
                        return false;
                }
            }
        }
        return openParenthesis.isEmpty();
    }

}

/**
 * Sample input:
 * {{}[]()}
 * 
 * Sample output:
 * Balanced
 */