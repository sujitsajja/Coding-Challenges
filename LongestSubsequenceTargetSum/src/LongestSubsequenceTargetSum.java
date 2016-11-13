import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Find the longest sub sequence in the given array that sums upto a maximum of given number
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-11-12
 */

public class LongestSubsequenceTargetSum {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array : ");
        int size = sc.nextInt();
        int[] input = new int[size];
        System.out.println("Enter the numbers seperated by space/enter :");
        for(int i=0;i<size;i++) {
            input[i] = sc.nextInt();
        }
        System.out.print("Enter the target sum : ");
        int n = sc.nextInt();
        List<Integer> subSequenceIndices = findIndicesOfLargestSubsequence(input, n);
        if(subSequenceIndices.isEmpty()) {
            System.out.println("All the elements in the given array are greater than the target");
        } else {
            System.out.println("The largest sub sequence that sums upto a maximum of given target is :");
            for(int i=subSequenceIndices.get(0);i<subSequenceIndices.get(1);i++) {
                System.out.print(input[i] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * Function to find the largest sub sequence in the given array that sums upto a maximum of given target
     * @param input
     * @param target
     * @return indices of largest sub sequence
     */
    private static List<Integer> findIndicesOfLargestSubsequence(int[] input, int target) {
        List<Integer> indices = new ArrayList<>();
        int tempSum = 0;
        int tempLeft = -1;
        int tempRight = -1;
        int finalLeft = -1;
        int finalRight = -1;
        for(int i=0;i<input.length;i++) {
            if(tempLeft == -1 && input[i] < target) {
                tempLeft = i;
                tempRight = i;
            }
            tempSum += input[i];
            tempRight++;
            while(tempSum > target && tempLeft != -1) {
                tempSum -= input[tempLeft];
                tempLeft++;
            }
            if(tempRight - tempLeft > finalRight - finalLeft && tempLeft != -1) {
                finalLeft = tempLeft;
                finalRight = tempRight;
            }
        }
        if(finalLeft != -1) {
            indices.add(finalLeft);
            indices.add(finalRight);
        }
        return indices;
    }
    
}

/**
 * Sample Input 1:
 * Array  : 5 6 7 8 9 10 11
 * Target : 4
 * 
 * Sample Output 1:
 * All the elements in the given array are greater than the target
 * 
 * Sample Input 2:
 * Array  : 9 1 8 2 7 3 6 4 5
 * Target : 17
 * 
 * Sample Output 2:
 * The largest sub sequence that sums upto a maximum of given target is : 1 8 2
 */