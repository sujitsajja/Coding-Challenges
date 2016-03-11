import java.util.Scanner;

/**
 * Given an array of n-1 integers between 1 to n find the missing number
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-10
 */

public class FindMissingOne {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array : ");
        int n = in.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the elements of the array seperated by space/enter :");
        for(int i=0;i<n;i++)
            input[i] = in.nextInt();
        int k = findMissing(input);
        System.out.println("The missing element of given input is :"+k);
    }

    /**
     * Function to find missing element in the given array
     * 
     * @param input integer array
     * 
     * @return missing number
     */
    private static int findMissing(int[] input) {
        int size = input.length;
        int expectedSum = (size+1)*(size+2)/2;
        int sum=0;
        for(int i=0;i<size;i++)
            sum += input[i];
        return expectedSum - sum;
    }

}

/**
 * Sample input:
 * 10
 * 1 3 4 5 6 7 8 9 10 11
 * 
 * Sample output:
 * 2
 */