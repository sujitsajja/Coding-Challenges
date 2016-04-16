import java.util.Scanner;
import java.util.Stack;

/**
 * To evaluate the given expression in reverse polish notation
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2014-04-16
 */

public class EvaluateExpression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the expression seperated by space :");
        String expression = sc.nextLine();
        int result = evaluateExpression(expression);
        System.out.println("The result is "+result);
    }

    /**
     * Function to evaluate the given expression
     * 
     * @param expression Reverse polish notation of expression
     * 
     * @return Result of the expression
     */
    private static int evaluateExpression(String expression) {
        String[] input = expression.split("\\s+");
        Stack<Integer> st = new Stack<>();
        for (String temp : input) {
            switch(temp){
                case "+":
                {
                    int one = st.pop();
                    int two = st.pop();
                    int result = one + two;
                    st.push(result);
                    break;
                }
                case "-":
                {
                    int one = st.pop();
                    int two = st.pop();
                    int result = two - one;
                    st.push(result);
                    break;
                }
                case "*":
                {
                    int one = st.pop();
                    int two = st.pop();
                    int result = one * two;
                    st.push(result);
                    break;
                }
                case "/":
                {
                    int one = st.pop();
                    int two = st.pop();
                    int result = two/one;
                    st.push(result);
                    break;
                }
                default:
                {
                    int number = Integer.parseInt(temp);
                    st.push(number);
                    break;
                }
            }
        }
        return st.pop();
    }
    
}

/**
 * Sample Input:
 * 4 13 5 / +
 * 
 * Sample Output:
 * 6
 */