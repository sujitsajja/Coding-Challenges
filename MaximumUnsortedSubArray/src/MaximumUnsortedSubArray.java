import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given an array find two indices such that by sorting the elements between
 * those two indices, the entire array will be sorted in ascending order
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-10-22
 */

public class MaximumUnsortedSubArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements : ");
        int n = sc.nextInt();
        int[] input = new int[n];
        System.out.println("Enter the elements seperated by space/enter :");
        for(int i=0;i<n;i++) {
            input[i] = sc.nextInt();
        }
        ArrayList<Integer> result = findMaximumUnsortedSubArray(input);
        if(result.isEmpty()) {
            System.out.println("The array is already sorted");
        } else {
            System.out.println("The array needs to be sorted from index " + result.get(0) + " to index " + result.get(1));
        }
    }
    
    /**
     * Function to find the indices of maximum unsorted sub array
     * @param input
     * @return start index and end index
     */
    private static ArrayList<Integer> findMaximumUnsortedSubArray(int[] input) {
        ArrayList<Integer> result = new ArrayList<>();
        int previous = -1;
        int left = -1;
        int right = -1;
        boolean failed = false;
        int minimumAfterFailure = Integer.MAX_VALUE;
        int maximumAfterFailure = Integer.MIN_VALUE;
        for(int i=0;i<input.length;i++) {
            if(input[i] < previous && !failed) {
                failed = true;
                minimumAfterFailure = input[i];
                maximumAfterFailure = input[i-1];
                right = i;
                continue;
            }
            if(input[i] < maximumAfterFailure) {
                right = i;
            } else {
                maximumAfterFailure = input[i];
            }
            if(input[i] < minimumAfterFailure) {
                minimumAfterFailure = input[i];
            }
            previous = input[i];
        }
        if(failed) {
            for(int i=0;i<input.length;i++) {
                if(input[i] > minimumAfterFailure) {
                    left = i;
                    break;
                }
            }
            result.add(left);
            result.add(right);
        }
        return result;
    }
    
}

/**
 * Sample Input:
 * 1 3 2 4 5
 * 
 * Sample Output:
 * [1, 2]
 */