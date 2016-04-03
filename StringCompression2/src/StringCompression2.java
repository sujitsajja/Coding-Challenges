import java.util.Scanner;

/**
 * To compress the string using recursion
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-04-03
 */

public class StringCompression2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string to be compressed : ");
        String input = sc.next();
        String output = compress(input);
        System.out.println("The string after compression is : "+output);
    }

    /**
     * Function to compress the string
     * 
     * @param input String to be compressed
     * 
     * @return Compressed string
     */
    private static String compress(String input) {
        char first = input.charAt(0);
        int count = 1;
        return compress(input,first,count,1).toString();
    }

    /**
     * Recursive function to compress the string
     * 
     * @param input String to be compressed
     * @param curr Current character
     * @param count Number of times the current character is repeated
     * @param index Position of string currently considered
     * 
     * @return Compressed String
     */
    private static StringBuilder compress(String input, char curr, int count, int index) {
        StringBuilder current = new StringBuilder();
        // If end of string is reached
        if(input.length()==index){
            current.append(curr);
            current.append(count);
            return current;
        }
        char temp = input.charAt(index);
        // If current char is same as previous
        // then we just increment the pointer and counter
        if(temp == curr)
            return compress(input, curr, count+1, index+1);
        // If current char is not same as previous
        // then we compress the previous one
        // and recursively compress the remaining
        else{
            current.append(curr);
            current.append(count);
            current.append(compress(input, temp, 1, index+1).toString());
            return current;
        }
    }

}