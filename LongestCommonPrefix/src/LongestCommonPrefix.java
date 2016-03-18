import java.util.Scanner;

/**
 * Given an array of strings find the longest common prefix
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-18
 */

public class LongestCommonPrefix {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of strings in the array : ");
        int n = sc.nextInt();
        String[] input = new String[n];
        System.out.println("Enter the strings seperated by Space/Enter :");
        for(int i=0;i<n;i++)
            input[i] = sc.next();
        System.out.println("The common prefix of the given strings are : "+findCommonPrefix(input));
    }

    /**
     * Function to find the common prefix of the given strings
     * 
     * @param input Array of strings
     * 
     * @return Common prefix of the given strings
     */
    private static String findCommonPrefix(String[] input) {
        int n = input.length;
        if(n==1)
            return input[0];
        int minLength = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(input[i].length()<minLength)
                minLength = input[i].length();
        }
        int i=0;
        for(;i<minLength;i++){
            char current = input[0].charAt(i);
            for(int j=1;j<n;j++){
                if(input[j].charAt(i)!=current)
                    return input[0].substring(0, i);
            }
        }
        return input[0].substring(0, minLength);
    }

}

/**
 * Sample input:
 * 3
 * abcdefgh
 * aefghijk
 * abcefgh
 * 
 * Sample output:
 * a
 */