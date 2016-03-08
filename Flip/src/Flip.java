import java.util.ArrayList;
import java.util.Scanner;

/**
 * Maximize the number of one's in the input by
 * flipping all the characters between two indices
 * 
 * @author SujitS
 * 
 * @version 1.2
 * @since 2016-03-07
 */

public class Flip {
    /**
     * @param args Command line argument
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the input binary string : ");
        String input = in.next();
        ArrayList<Integer> indexes = flip(input);
        if(indexes.isEmpty())
            System.out.println("The input has maximum number of 1's");
        else
            System.out.println("The elements from index "+indexes.get(0)+" to index "+indexes.get(1)+" should be flipped to get a maximmum number of 1's");
    }

    /**
     * Function to find two indices such that by flipping all the
     * characters between them will result in maximum number of ones
     * 
     * @param A Input String
     * 
     * @return Arraylist of two indices(From,To)
     */
    private static ArrayList<Integer> flip(String A) {
        ArrayList<Integer> result = new ArrayList<>();
        A = A.trim();
        int length = A.length();
        int[] intArray = new int[length];
        // Logic used is similar to kadanes algorithm.
        // Replace zeros with -1 and instead of finding the maximum sum,
        // find the start index and end index of maximum sum sub array
        for(int i=0;i<length;i++){
            int temp = Character.getNumericValue(A.charAt(i));
            if(temp==1)
                temp = -1;
            else
                temp = 1;
            intArray[i] = temp;
        }
        int tempSum=0,maxSum=0,left=-1,right=-1,finalLeft=-1;
        // tempsum contains sum of current sub array
        // maxSum compares and stores the maximum of tempsum
        // left and finalLeft are used to store start index of tempsum and maxsum respectively
        // right is used to store end index of maxsum
        for(int i=0;i<length;i++){
            if(left==-1)
                left=i;
            tempSum += intArray[i];
            if(tempSum<0){
                tempSum=0;
                left=-1;
            }
            if(maxSum<tempSum){
                finalLeft = left;
                maxSum = tempSum;
                right = i;
            }
        }
        if(right==-1)
            return result;
        result.add(finalLeft+1);
        result.add(right+1);
        return result;
    }

}