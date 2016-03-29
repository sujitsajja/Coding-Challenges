import java.util.Scanner;

/**
 * To compress the given string
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-29
 */

public class StringCompression {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the string to be compressed : ");
        String input = sc.next();
        String output = stringCompress(input);
        System.out.println("The string after compression is : "+output);
    }

    private static String stringCompress(String input) {
        int length = input.length();
        int count = 0;
        StringBuilder output = new StringBuilder();
        char curr = input.charAt(0);
        for(int i=0;i<length;i++){
            char temp = input.charAt(i);
            if(curr == temp)
                count++;
            else{
                output.append(curr);
                output.append(count);
                count = 1;
                curr = temp;
            }
        }
        output.append(curr);
        output.append(count);
        return output.toString();
    }
    
}