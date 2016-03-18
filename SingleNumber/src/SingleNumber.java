import java.util.Scanner;

/**
 * Given two strings check if they are anagrams or not
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-18
 */

public class SingleNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array : ");
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the elements of array seperated by Space/Enter :");
        for(int i=0;i<n;i++)
            input[i] = sc.nextInt();
        int k = findSingleNumber(input);
        System.out.println("The only number that does not repeat twice is : "+k);
    }

    /**
     * Function to find the number that appears only once in the given array
     * 
     * @param input Array of integers
     * 
     * @return Number that does not repeat
     */
    private static int findSingleNumber(int[] input) {
        int n = input.length;
        int singleNumber = input[0];
        // XOR operation eliminates duplicates which will
        // result in a number that does not repeat
        for(int i=1;i<n;i++)
            singleNumber ^= input[i];
        return singleNumber;
    }

}

/**
 * Sample input:
 * 5
 * 1 2 2 3 1
 * 
 * Sample output:
 * 3
 */