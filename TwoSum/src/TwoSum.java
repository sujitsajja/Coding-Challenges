import java.util.ArrayList;
import java.util.Scanner;

/**
 * Given a sorted array find two elements whose sum is equal to 
 * the given target .If such a pair does not exist return -1
 * 
 * @author SujitS
 * 
 * @version 1.0
 * @since 2016-03-19
 */

public class TwoSum {

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
        System.out.print("Enter the target sum : ");
        int target = sc.nextInt();
        ArrayList<Integer> pair = findPair(input,target);
        if(!pair.isEmpty())
            System.out.println("The elements that sum to target are "
                    +pair.get(0)+" & "+pair.get(1));
        else
            System.out.println("There are no elements that sum upto given target");
    }

    /**
     * Function to find a pair of elements in the
     * array that sum upto the given target
     * 
     * @param input Array of integers
     * @param target Target Sum
     * 
     * @return Pair of Elements that sum upto target
     */
    private static ArrayList<Integer> findPair(int[] input, int target) {
        int n = input.length;
        ArrayList<Integer> pair = new ArrayList<>();
        for(int i=0,j=n-1;j>i;){
            // Increment the left pointer if the sum is less than target
            if(input[i]+input[j]<target)
                i++;
            // Increment the right pointer if the sum is more than target
            else if(input[i]+input[j]>target)
                j--;
            else{
                pair.add(input[i]);
                pair.add(input[j]);
                break;
            }
        }
        return pair;
    }

}

/**
 * Sample input:
 * 10
 * 0 1 2 3 4 5 6 7 8 9
 * 14
 * 
 * Sample output:
 * 5 9
 */